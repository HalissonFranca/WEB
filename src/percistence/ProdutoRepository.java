package com.example.Produto.percistence;

import com.example.Produto.model.Cliente;
import com.example.Produto.model.Pedido;
import com.example.Produto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//public interface ProdutoRepository extends JpaRepository<Produto, Long> {
//    Optional<Produto> findByNome(String nome);
//
//}

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findByNome(String nome);
}