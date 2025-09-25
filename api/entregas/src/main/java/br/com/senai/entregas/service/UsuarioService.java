package br.com.senai.entregas.service;

import br.com.senai.entregas.model.Usuario;
import br.com.senai.entregas.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuario, PasswordEncoder passwordEncoder) {
        usuarioRepository = usuario;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(Integer id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario createUsuario(Usuario usuario){
        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);

        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(Usuario usuario, Integer id){
        Usuario user = getUsuarioById(id);

        if (user == null){
            return null;
        }

        user.setEmail(usuario.getEmail());
        user.setSenha(usuario.getSenha());
        user.setTipoUsuario(usuario.getTipoUsuario());
        user.setNomeCompleto(usuario.getNomeCompleto());

        return usuarioRepository.save(user);
    }

    public Usuario deleteUsuario(Integer id){
        Usuario user = getUsuarioById(id);

        if (user == null) {
            return null;
        }

        usuarioRepository.delete(user);
        return user;
    }

}
