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
@Table(name = "enderecos")
public class Enderecos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_id", nullable = false)
    private Integer enderecoId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "cliente_id")
    private TipoUsuario clieteId;

    @Column(name = "logradouro", nullable = false, unique = true, columnDefinition = "TEXT")
    private String logradouro;

    @Column(name = "numero", nullable = false, columnDefinition = "TEXT")
    private String numero;

    @Column(name = "cidade", nullable = false, columnDefinition = "TEXT")
    private String cidade;

    @Column(name = "cep", nullable = false, columnDefinition = "TEXT")
    private String cep;
}
