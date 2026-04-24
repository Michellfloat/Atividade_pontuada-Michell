package com.example.atv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atv.model.ProdutoModel;
import com.example.atv.repository.ProdutoRepository;

@Service /* Inserindo a camada de serviço para Produtos */
public class ProdutoService { 
    @Autowired /* Injetando o repositório de Produtos */
    private ProdutoRepository produtoRepository; /* Variável para acessar os métodos do repositório de Produtos */

    public List<ProdutoModel>listarProdutos(){ /* Método para listar todos os produtos */
        return produtoRepository.findAll(); /* Retorna uma lista de todos os produtos cadastrados no banco de dados */
    }

    public ProdutoModel salvarProdutos(ProdutoModel produto){ /* Método para salvar um produto */
        if (produtoRepository.findByLote(produto.getLote()).isPresent()) { /* Verifica se já existe um produto com o mesmo lote */
            throw new RuntimeException("Lote já existente..."); /* Lança uma exceção caso o produto já exista */
        }
        return produtoRepository.save(produto); /* Salva o produto no banco de dados e retorna o produto salvo */
    }

    public ProdutoModel atualizarProdutos(Long id, ProdutoModel produto){ /* Método para atualizar um produto */
        if (!produtoRepository.existsById(id)) { /* Verifica se o produto existe antes de atualizar */
            throw new IllegalArgumentException("Produto não encontrado,tente novamente!!"); /* Lança uma exceção caso o produto não exista */
        }
        produto.setId(id); /* Define o ID do produto a ser atualizado */
        return produtoRepository.save(produto); /* Salva as alterações do produto no banco de dados e retorna o produto atualizado */
    }

    public void deletarProdutos(Long id){ /* Método para deletar um produto */
        if (!produtoRepository.existsById(id)) { /* Verifica se o produto existe antes de deletar */
            throw new IllegalArgumentException("Produto não encontrado,tente novamente!!"); /* Lança uma exceção caso o produto não exista */
        }
        produtoRepository.deleteById(id); /* Deleta o produto do banco de dados pelo ID */
    }
}
