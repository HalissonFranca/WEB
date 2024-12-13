package com.example.Produto.percistence;

import com.example.Produto.model.Cliente;
import com.example.Produto.model.Pedido;
import com.example.Produto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// PedidoRepository.java
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByIdCliente(Long idCliente);

    List<Pedido> findByIdsProdutosContaining(Long idProduto);
}
