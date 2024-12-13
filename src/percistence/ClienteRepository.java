package com.example.Produto.percistence;

import java.util.Optional;

import com.example.Produto.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Produto.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByNome(String nome);
}


