package com.example.Produto.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String contato;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String email, String contato) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.contato = contato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }


    @Override
    public String toString() {
        return "Id: " + id + ", Nome: " + nome + ", Email: " + email + ", Contato: " + contato;
    }

}
