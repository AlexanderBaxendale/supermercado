package com.jb.supermercado.internal.produto.mapper;

import com.jb.supermercado.internal.produto.dto.ProdutoRequestRecord;
import com.jb.supermercado.internal.produto.dto.ProdutoResponseRecord;
import com.jb.supermercado.internal.produto.entity.ProdutoEntity;
import com.jb.supermercado.internal.usuario.dto.UsuarioResponseRecord;

import java.util.ArrayList;
import java.util.List;

public class ProdutoMapperRecord {

    public static ProdutoEntity produtoRequest(ProdutoRequestRecord produtoRequest){
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setNome(produtoRequest.nome());
        produtoEntity.setDescricao(produtoRequest.descricao());
        produtoEntity.setQuantidadeEstoque(produtoRequest.quantidadeEstoque());
        produtoEntity.setStatus(produtoRequest.status());
        return produtoEntity;
    }

    public static ProdutoResponseRecord produtoResponse(ProdutoEntity produtoEntity){
        return new ProdutoResponseRecord(
                produtoEntity.getId(),
                produtoEntity.getNome(),
                produtoEntity.getDescricao(),
                produtoEntity.getQuantidadeEstoque(),
                produtoEntity.getStatus());
    }

    public static List<ProdutoResponseRecord> produtoResponseRecordList(List<ProdutoEntity> produtoList){
        List<ProdutoResponseRecord> produtoArray = new ArrayList<>();
        for (ProdutoEntity produtoEntity : produtoList ){
            produtoArray.add(produtoResponse(produtoEntity));
        }
        return produtoArray;
    }
}
