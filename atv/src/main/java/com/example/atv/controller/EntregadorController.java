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

import com.example.atv.model.EntregadorModel;
import com.example.atv.service.EntregadorService;

@RestController
@RequestMapping("/entregadores")
public class EntregadorController {
     @Autowired
    private EntregadorService entregadorService;

    @GetMapping
    public List<EntregadorModel>listar(){
       return entregadorService.listarEntregadores();
    }

    @PostMapping
    public ResponseEntity<Map<String,Object>>salvar(@RequestBody EntregadorModel entregador){
        entregadorService.salvarEntregadores(entregador);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem","entregador Cadastrado com sucesso!!"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String,Object>>atualizar(@PathVariable Long id,@RequestBody EntregadorModel entregador){
        entregadorService.atualizarEntregadores(id, entregador);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem","Dados do entregador alterados com sucesso!!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Object>>deletar(@PathVariable Long id){
        entregadorService.deletarEntregadores(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem","entregador excluído com sucesso!!"));
    }
}
