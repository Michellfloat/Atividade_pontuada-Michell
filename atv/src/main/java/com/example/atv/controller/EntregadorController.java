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

@RestController /* Inserindo a camada de controle para Entregadores */
@RequestMapping("/entregadores") /* Define o endpoint base para as operações relacionadas a entregadores */
public class EntregadorController {
     @Autowired /* Injetando a camada de serviço de Entregadores */
    private EntregadorService entregadorService; /* Injetando a camada de serviço de Entregadores para que o controlador possa chamar os métodos da camada de serviço e realizar as operações relacionadas aos entregadores */

    @GetMapping /* Método para listar todos os entregadores */
    public List<EntregadorModel>listar(){ /* Retorna uma lista de todos os entregadores cadastrados */
       return entregadorService.listarEntregadores(); /* Chama o método listarEntregadores da camada de serviço para obter a lista de entregadores e retorna essa lista como resposta */
    }

    @PostMapping /* Método para salvar um entregador */
    public ResponseEntity<Map<String,Object>>salvar(@RequestBody EntregadorModel entregador){ /* Recebe os dados do entregador no corpo da requisição e chama o método salvarEntregadores da camada de serviço para salvar o entregador no banco de dados */
        entregadorService.salvarEntregadores(entregador); /* Salva o entregador no banco de dados usando a camada de serviço */
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem","entregador Cadastrado com sucesso!!")); /* Retorna uma resposta HTTP com status 201 (Created) e uma mensagem indicando que o entregador foi cadastrado com sucesso */
    }

    @PutMapping("/{id}") /* Método para atualizar um entregador, recebe o ID do entregador a ser atualizado como parte da URL e os dados atualizados do entregador no corpo da requisição */
    public ResponseEntity<Map<String,Object>>atualizar(@PathVariable Long id,@RequestBody EntregadorModel entregador){ /* Chama o método atualizarEntregadores da camada de serviço para atualizar os dados do entregador no banco de dados usando o ID fornecido e os dados atualizados do entregador */
        entregadorService.atualizarEntregadores(id, entregador); /* Atualiza os dados do entregador no banco de dados usando a camada de serviço */
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem","Dados do entregador alterados com sucesso!!")); /* Retorna uma resposta HTTP com status 200 (OK) e uma mensagem indicando que os dados do entregador foram alterados com sucesso */
    }

    @DeleteMapping("/{id}") /* Método para deletar um entregador, recebe o ID do entregador a ser deletado como parte da URL */
    public ResponseEntity<Map<String,Object>>deletar(@PathVariable Long id){ /* Chama o método deletarEntregadores da camada de serviço para deletar o entregador do banco de dados usando o ID fornecido */
        entregadorService.deletarEntregadores(id); /* Deleta o entregador do banco de dados usando a camada de serviço */
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem","entregador excluído com sucesso!!")); /* Retorna uma resposta HTTP com status 200 (OK) e uma mensagem indicando que o entregador foi excluído com sucesso */
    }
}
