package br.com.senai.entregas.model;

import jakarta.persistence.*;
import lombok.*;

// Lombook
@Getter
@Setter

//Obrigatorio para o JPA funcionar
@NoArgsConstructor
@AllArgsConstructor


// JPA
//Inforoma que a classe, e uma tabela
@Entity
// Permite a configuracao da tabela
@Table(name = "tipo_usuarios")

public class TipoUsuario {

//    Define que e chave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tipo_usuario_id", nullable=false)
    private Integer tipoUsuarioId;

    @Column(name="descricao", nullable=false, columnDefinition = "TEXT")
    private String descricao;

}
