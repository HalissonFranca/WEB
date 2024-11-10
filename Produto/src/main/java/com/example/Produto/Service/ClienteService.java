package com.example.Produto.Service;

import com.example.Produto.model.Cliente;
import com.example.Produto.percistence.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// ClienteService.java
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> listarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Optional<Cliente> listarPorNome(String nome) {
        return clienteRepository.findByNome(nome);
    }
}

