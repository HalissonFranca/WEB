package com.example.Produto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idCliente;
    @ElementCollection
    private List<Long> idsProdutos;

    public Pedido() {}

    // Construtor com parâmetros
    public Pedido(Long id, Long idCliente, List<Long> idsProdutos) {
        this.id = id;
        this.idCliente = idCliente;
        this.idsProdutos = idsProdutos;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public List<Long> getIdsProdutos() {
        return idsProdutos;
    }

    public void setIdsProdutos(List<Long> idsProdutos) {
        this.idsProdutos = idsProdutos;
    }

    // Método toString para exibir o pedido
    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", idCliente=" + idCliente +
                ", idsProdutos=" + idsProdutos +
                '}';
    }
}