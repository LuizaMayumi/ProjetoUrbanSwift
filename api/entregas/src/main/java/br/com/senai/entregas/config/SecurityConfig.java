package br.com.senai.entregas.config;

import com.nimbusds.jose.jwk.source.ImmutableSecret;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.spec.SecretKeySpec;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private String secret = "0U>LnHwB]_U5Mko?Lq&_r,ZKA:A7-5";
    // https://www.lastpass.com/pt/features/password-generator


    @Bean
//    BEAN metodo de configuracao
//    Hashing de senha
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
//    Tokens (JWT)
    public JwtEncoder jwtEncoder() {
        var secretKey = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
        return new NimbusJwtEncoder(new ImmutableSecret<>(secretKey));
    }

    @Bean
//    Descriptografar o token
    public JwtDecoder jwtDecoder() {
        var secretKey = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
        return NimbusJwtDecoder.withSecretKey(secretKey).macAlgorithm(MacAlgorithm.HS256).build();
    }

//    Configura o gerente da configuracao
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
}
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                // PRECISAMOS desligar o CORS para permitir que outros sites acessem nossa API
                .cors(cors -> cors.disable())
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // AQUI MODIFICAMOS:
                .authorizeHttpRequests(auth -> auth
                        // 1. Define as rotas que são PÚBLICAS.
                        // Qualquer requisição para "/api/auth/**" (nosso login) será permitida.
                        .requestMatchers("/api/auth/**").permitAll()
                        // Também permite acesso à documentação do Swagger, se você a utilizar.
                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html", "/api-docs/**").permitAll()

                        // 2. Define que TODAS AS OUTRAS rotas devem ser autenticadas.
                        // Esta é a nossa regra "negar por padrão": se não foi explicitamente liberado,
                        // o acesso é bloqueado e exige um token válido.
                        .anyRequest().authenticated()
                )

                // AQUI ESTÁ A ATIVAÇÃO DO VALIDADOR DE JWT:
                // 3. "Contrata" a empresa de segurança do Spring para validar os tokens.
                // Esta linha ativa um filtro que intercepta requisições, procura o token JWT
                // no cabeçalho Authorization e usa nosso JwtDecoder para validá-lo.
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));

        return http.build();
    }
}
