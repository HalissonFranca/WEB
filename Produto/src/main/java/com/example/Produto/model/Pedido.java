//package com.example.Produto.model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Table;
//import jakarta.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "pedido")
//public class Pedido {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private Long idCliente;
//    @ElementCollection
//    private List<Long> idProdutos;
//
//    public Pedido() {}
//
//    // Construtor com parâmetros
//    public Pedido(Long id, Long idCliente, List<Long> idProdutos) {
//        this.id = id;
//        this.idCliente = idCliente;
//        this.idProdutos = idProdutos;
//    }
//
//    // Getters e Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getIdCliente() {
//        return idCliente;
//    }
//
//    public void setIdCliente(Long idCliente) {
//        this.idCliente = idCliente;
//    }
//
//    public List<Long> getIdsProdutos() {
//        return idProdutos;
//    }
//
//    public void setIdsProdutos(List<Long> idsProdutos) {
//        this.idProdutos = idsProdutos;
//    }
//
//    // Método toString para exibir o pedido
//    @Override
//    public String toString() {
//        return "Pedido{" +
//                "id=" + id +
//                ", idCliente=" + idCliente +
//                ", idsProdutos=" + idProdutos +
//                '}';
//    }
//}

package com.example.Produto.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamento Many-to-One com Cliente
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "pedido_produto",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos;



    // Construtores
    public Pedido() {}

    // Construtor com parâmetros
    public Pedido(Long id, Cliente cliente, List<Produto> produtos) {
        this.id = id;
        this.cliente = cliente;
        this.produtos = produtos;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente.getNome() +  // Exibe o nome do cliente
                ", produtos=" + produtos +  // Exibe a lista de produtos
                '}';
    }
}