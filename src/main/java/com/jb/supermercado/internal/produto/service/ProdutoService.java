package com.jb.supermercado.internal.produto.service;

import com.jb.supermercado.config.exception.BusinessException;
import com.jb.supermercado.config.exception.RecursoNaoEncontradoException;
import com.jb.supermercado.internal.produto.dto.ProdutoRequestRecord;
import com.jb.supermercado.internal.produto.dto.ProdutoResponseRecord;
import com.jb.supermercado.internal.produto.entity.ProdutoEntity;
import com.jb.supermercado.internal.produto.mapper.ProdutoMapperRecord;
import com.jb.supermercado.internal.produto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void cadastrarProduto(ProdutoRequestRecord produtoRequest){
        boolean nome_existe = this.produtoRepository.existsByNome(produtoRequest.nome());
        if(nome_existe){
            throw new BusinessException("Já existe um produto cadastrado com esse nome!");
        }
        ProdutoEntity produtoEntity = ProdutoMapperRecord.produtoRequest(produtoRequest);
        this.produtoRepository.save(produtoEntity);
    }

    public ProdutoResponseRecord buscarProdutoPorId(Long id) {
        ProdutoEntity produtoEntity = this.produtoRepository.findById(id).orElseThrow(() ->
                new RecursoNaoEncontradoException("Produto não Encontrado"));
        return ProdutoMapperRecord.produtoResponse(produtoEntity);
    }

    public List<ProdutoResponseRecord> listaProdutos(){
        List<ProdutoEntity> produtos = this.produtoRepository.findAll();
        return ProdutoMapperRecord.produtoResponseRecordList(produtos);
    }

    public void atualizarProduto(Long id, ProdutoRequestRecord produtoRequest){
        ProdutoEntity produtoEntity = this.produtoRepository.findById(id).orElseThrow(() ->
                new RecursoNaoEncontradoException("Produto não Encontrado")
        );
        produtoEntity.setNome(produtoRequest.nome());
        produtoEntity.setDescricao(produtoRequest.descricao());
        produtoEntity.setQuantidadeEstoque(produtoRequest.quantidadeEstoque());
        produtoEntity.setStatus(produtoRequest.status());
        this.produtoRepository.save(produtoEntity);
    }

    public void removerProduto(Long id){
        this.produtoRepository.deleteById(id);
    }

}
