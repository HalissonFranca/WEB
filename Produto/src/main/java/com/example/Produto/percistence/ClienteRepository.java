package com.example.Produto.percistence;

import java.util.Optional;

import com.example.Produto.model.Cliente;  // Mantém apenas uma importação

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByNome(String nome);
}
