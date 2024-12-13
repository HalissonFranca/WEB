package com.example.Produto.Service;

import com.example.Produto.model.Pedido;
import com.example.Produto.percistence.ClienteRepository;
import com.example.Produto.percistence.PedidoRepository;
import com.example.Produto.percistence.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// PedidoService.java
@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public Pedido salvar(Pedido pedido) {
        if (!clienteRepository.existsById(pedido.getIdCliente())) {
            throw new IllegalArgumentException("Cliente inválido.");
        }
        if (pedido.getIdsProdutos() == null || pedido.getIdsProdutos().isEmpty()) {
            throw new IllegalArgumentException("Pedido deve conter ao menos um produto.");
        }
        for (Long idProduto : pedido.getIdsProdutos()) {
            if (!produtoRepository.existsById(idProduto)) {
                throw new IllegalArgumentException("Produto inválido.");
            }
        }
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> listarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public List<Pedido> listarPorIdCliente(Long idCliente) {
        return pedidoRepository.findByIdCliente(idCliente);
    }

    public List<Pedido> listarPorIdProduto(Long idProduto) {
        return pedidoRepository.findByIdsProdutosContaining(idProduto);
    }
}

