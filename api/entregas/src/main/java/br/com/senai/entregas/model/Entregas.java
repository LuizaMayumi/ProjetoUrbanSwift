package br.com.senai.entregas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "entregas")
public class Entregas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entrega_id", nullable = false)
    private Integer entregaId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "cliente_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "endereco_id")
    private Enderecos endereco;

    @Column(name = "descricao_produto", nullable = false, columnDefinition = "TEXT")
    private String descricaoProduto;

    @Column(name = "status", nullable = false, columnDefinition = "TEXT")
    private String status;

    @Column(name = "data_pedido", nullable = false)
    private Date dataPedido;

}
