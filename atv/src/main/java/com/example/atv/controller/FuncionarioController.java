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

import com.example.atv.model.FuncionarioModel;
import com.example.atv.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<FuncionarioModel>listar(){
       return funcionarioService.listarFuncionarios();
    }

    @PostMapping
    public ResponseEntity<Map<String,Object>>salvar(@RequestBody FuncionarioModel funcionario){
        funcionarioService.salvarFuncionarios(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem","funcionario Cadastrado com sucesso!!"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String,Object>>atualizar(@PathVariable Long id,@RequestBody FuncionarioModel funcionario){
        funcionarioService.atualizarFuncionarios(id, funcionario);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem","Dados do funcionario alterados com sucesso!!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Object>>deletar(@PathVariable Long id){
        funcionarioService.deletarFuncionarios(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem","funcionario excluído com sucesso!!"));
    }
}
