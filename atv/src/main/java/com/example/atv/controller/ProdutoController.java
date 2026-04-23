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

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoModel>listar(){
       return produtoService.listarProdutos();
    }

    @PostMapping
    public ResponseEntity<Map<String,Object>>salvar(@RequestBody ProdutoModel produto){
        produtoService.salvarProdutos(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem","Produto Cadastrado com sucesso!!"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String,Object>>atualizar(@PathVariable Long id,@RequestBody ProdutoModel produto){
        produtoService.atualizarProdutos(id, produto);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem","Dados do Produto alterados com sucesso!!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Object>>deletar(@PathVariable Long id){
        produtoService.deletarProdutos(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem","produto excluído com sucesso!!"));
    }

}
