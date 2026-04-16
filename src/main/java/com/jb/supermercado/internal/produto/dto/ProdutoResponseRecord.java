package com.jb.supermercado.internal.produto.dto;

public record ProdutoResponseRecord(Long id, String nome, String descricao, String status, int quantidadeEstoque) {
}
