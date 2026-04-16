package com.jb.supermercado.internal.produto.dto;


import jakarta.validation.constraints.NotBlank;

public record ProdutoRequestRecord(

        @NotBlank(message = "O campo nome é Obrigatorio")
        String nome,
        @NotBlank(message = "O campo descrição é Obrigatorio ")
        String descricao,
        @NotBlank(message = "O campo quantidade é Obirgatorio")
        int quantidadeEstoque,
        @NotBlank(message = "O campo status é obrigatorio")
        String  status
) {
}
