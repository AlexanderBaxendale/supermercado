package com.jb.supermercado.internal.produto.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nome;
    private String descricao;
    private int quantidadeEstoque;
    private String  status;

    public ProdutoEntity(Long id, String status, int quantidadeEstoque, String descricao, String nome) {
        this.status = status;
        this.quantidadeEstoque = quantidadeEstoque;
        this.descricao = descricao;
        this.nome = nome;
        this.id= id;
    }

    public ProdutoEntity(Long id, String nome, String descricao, int quantidadeEstoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidadeEstoque = quantidadeEstoque;
        this.id = id;
    }

    public ProdutoEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
