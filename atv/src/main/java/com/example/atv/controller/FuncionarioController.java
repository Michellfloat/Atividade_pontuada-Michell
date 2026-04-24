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

@RestController /* Inserindo a camada de controle para Funcionarios */
@RequestMapping("/funcionarios") /* Define o endpoint base para as operações relacionadas a funcionarios */
public class FuncionarioController { /* Injetando a camada de serviço de Funcionarios para que o controlador possa chamar os métodos da camada de serviço e realizar as operações relacionadas aos funcionarios */
    
    @Autowired /* Injetando a camada de serviço de Funcionarios */
    private FuncionarioService funcionarioService; /* Injetando a camada de serviço de Funcionarios para que o controlador possa chamar os métodos da camada de serviço e realizar as operações relacionadas aos funcionarios */    

    @GetMapping /* Método para listar todos os funcionarios */
    public List<FuncionarioModel>listar(){ /* Retorna uma lista de todos os funcionarios cadastrados */
       return funcionarioService.listarFuncionarios(); /* Chama o método listarFuncionarios da camada de serviço para obter a lista de funcionarios e retorna essa lista como resposta */
    }

    @PostMapping /* Método para salvar um funcionario */
    public ResponseEntity<Map<String,Object>>salvar(@RequestBody FuncionarioModel funcionario){ /* Recebe os dados do funcionario no corpo da requisição e chama o método salvarFuncionarios da camada de serviço para salvar o funcionario no banco de dados */
        funcionarioService.salvarFuncionarios(funcionario); /* Salva o funcionario no banco de dados usando a camada de serviço */
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem","funcionario Cadastrado com sucesso!!")); /* Retorna uma resposta HTTP com status 201 (Created) e uma mensagem indicando que o funcionario foi cadastrado com sucesso */
    }

    @PutMapping("/{id}") /* Método para atualizar um funcionario, recebe o ID do funcionario a ser atualizado como parte da URL e os dados atualizados do funcionario no corpo da requisição */
    public ResponseEntity<Map<String,Object>>atualizar(@PathVariable Long id,@RequestBody FuncionarioModel funcionario){ /* Chama o método atualizarFuncionarios da camada de serviço para atualizar os dados do funcionario no banco de dados usando o ID fornecido e os dados atualizados do funcionario */
        funcionarioService.atualizarFuncionarios(id, funcionario); /* Atualiza os dados do funcionario no banco de dados usando a camada de serviço */
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem","Dados do funcionario alterados com sucesso!!")); /* Retorna uma resposta HTTP com status 200 (OK) e uma mensagem indicando que os dados do funcionario foram alterados com sucesso */
    }

    @DeleteMapping("/{id}") /* Método para deletar um funcionario, recebe o ID do funcionario a ser deletado como parte da URL */
    public ResponseEntity<Map<String,Object>>deletar(@PathVariable Long id){ /* Chama o método deletarFuncionarios da camada de serviço para deletar o funcionario do banco de dados usando o ID fornecido */
        funcionarioService.deletarFuncionarios(id); /* Deleta o funcionario do banco de dados usando a camada de serviço */
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem","funcionario excluído com sucesso!!")); /* Retorna uma resposta HTTP com status 200 (OK) e uma mensagem indicando que o funcionario foi excluído com sucesso */
    }
}
