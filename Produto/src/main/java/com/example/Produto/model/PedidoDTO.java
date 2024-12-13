package com.example.Produto.model;

import java.util.List;

public class PedidoDTO {

    private Long idCliente;
    private List<Long> idsProdutos;

    // Construtores
    public PedidoDTO() {}

    public PedidoDTO(Long idCliente, List<Long> idsProdutos) {
        this.idCliente = idCliente;
        this.idsProdutos = idsProdutos;
    }

    // Getters e Setters
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
}
