package com.example.atv.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.atv.model.ProdutoModel;
import com.example.atv.service.ProdutoService;

@RestController /* Inserindo a camada de controle para Produtos */
@RequestMapping("/produtos") /* Define o endpoint base para as operações relacionadas a produtos */
public class ProdutoController {
    @Autowired /* Injetando a camada de serviço de Produtos */
    private ProdutoService produtoService;

    @GetMapping/* Método para listar todos os produtos */
    public List<ProdutoModel>listar(){/* Retorna uma lista de todos os produtos cadastrados */
       return produtoService.listarProdutos();/* Chama o método listarProdutos da camada de serviço para obter a lista de produtos e retorna essa lista como resposta */
    }

    @PostMapping /* Método para salvar um produto */
    public ResponseEntity<Map<String,Object>>salvar(@RequestBody ProdutoModel produto){ /* Recebe os dados do produto no corpo da requisição e chama o método salvarProdutos da camada de serviço para salvar o produto no banco de dados */
        produtoService.salvarProdutos(produto); /* Salva o produto no banco de dados usando a camada de serviço */
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem","Produto Cadastrado com sucesso!!")); /* Retorna uma resposta HTTP com status 201 (Created) e uma mensagem indicando que o produto foi cadastrado com sucesso */
    }

    @PutMapping("/{id}") /* Método para atualizar um produto, recebe o ID do produto a ser atualizado como parte da URL e os dados atualizados do produto no corpo da requisição */
    public ResponseEntity<Map<String,Object>>atualizar(@PathVariable Long id,@RequestBody ProdutoModel produto){ /* Chama o método atualizarProdutos da camada de serviço para atualizar os dados do produto no banco de dados usando o ID fornecido e os dados atualizados do produto */
        produtoService.atualizarProdutos(id, produto); /* Atualiza os dados do produto no banco de dados usando a camada de serviço */
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem","Dados do Produto alterados com sucesso!!")); /* Retorna uma resposta HTTP com status 200 (OK) e uma mensagem indicando que os dados do produto foram alterados com sucesso */
    }

    @DeleteMapping("/{id}") /* Método para deletar um produto, recebe o ID do produto a ser deletado como parte da URL */
    public ResponseEntity<Map<String,Object>>deletar(@PathVariable Long id){ /* Chama o método deletarProdutos da camada de serviço para deletar o produto do banco de dados usando o ID fornecido */
        produtoService.deletarProdutos(id); /* Deleta o produto do banco de dados usando a camada de serviço */
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem","produto excluído com sucesso!!")); /* Retorna uma resposta HTTP com status 200 (OK) e uma mensagem indicando que o produto foi excluído com sucesso */
    }

}
