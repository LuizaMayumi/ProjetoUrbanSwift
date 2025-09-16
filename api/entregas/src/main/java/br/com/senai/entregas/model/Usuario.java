package br.com.senai.entregas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;

    @Column(name = "nome_completo", nullable = false, columnDefinition = "TEXT")
    private String nomeCompleto;

    @Column(name = "email", nullable = false, unique = true, columnDefinition = "TEXT")
    private String email;

    @Column(name = "senha", nullable = false, columnDefinition = "TEXT")
    private String senha;

//    Many e voltado para a classe atual
//    EAGER - carrega o usuario e o tipo juntos (A sua acao e igual a de um JOIN)

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "tipo_usuario_id")
    private TipoUsuario tipoUsuarioId;

}
