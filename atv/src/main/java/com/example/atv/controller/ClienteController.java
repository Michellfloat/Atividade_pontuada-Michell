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
import com.example.atv.model.ClienteModel;
import com.example.atv.service.ClienteService;

@RestController /* Inserindo a camada de controle para Clientes */
@RequestMapping("/clientes") /* Define o endpoint base para as operações relacionadas a clientes */
public class ClienteController {
    @Autowired /* Injetando a camada de serviço de Clientes */
    private ClienteService clienteService;

    @GetMapping /* Método para listar todos os clientes */
    public List<ClienteModel>listar(){ /* Retorna uma lista de todos os clientes cadastrados */
       return clienteService.listarClientes(); /* Chama o método listarClientes da camada de serviço para obter a lista de clientes e retorna essa lista como resposta */
    }

    @PostMapping /* Método para salvar um cliente */
    public ResponseEntity<Map<String,Object>>salvar(@RequestBody ClienteModel cliente){ /* Recebe os dados do cliente no corpo da requisição e chama o método salvarClientes da camada de serviço para salvar o cliente no banco de dados */
        clienteService.salvarClientes(cliente); /* Salva o cliente no banco de dados usando a camada de serviço */
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem","Cliente Cadastrado com sucesso!!")); /* Retorna uma resposta HTTP com status 201 (Created) e uma mensagem indicando que o cliente foi cadastrado com sucesso */
    }

    @PutMapping("/{id}") /* Método para atualizar um cliente, recebe o ID do cliente a ser atualizado como parte da URL e os dados atualizados do cliente no corpo da requisição */
    public ResponseEntity<Map<String,Object>>atualizar(@PathVariable Long id,@RequestBody ClienteModel cliente){ /* Chama o método atualizarClientes da camada de serviço para atualizar os dados do cliente no banco de dados usando o ID fornecido e os dados atualizados do cliente */
        clienteService.atualizarClientes(id, cliente); /* Atualiza os dados do cliente no banco de dados usando a camada de serviço */
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem","Dados do Cliente alterados com sucesso!!")); /* Retorna uma resposta HTTP com status 200 (OK) e uma mensagem indicando que os dados do cliente foram alterados com sucesso */
    }

    @DeleteMapping("/{id}") /* Método para deletar um cliente, recebe o ID do cliente a ser deletado como parte da URL */
    public ResponseEntity<Map<String,Object>>deletar(@PathVariable Long id){ /* Chama o método deletarClientes da camada de serviço para deletar o cliente do banco de dados usando o ID fornecido */
        clienteService.deletarClientes(id); /* Deleta o cliente do banco de dados usando a camada de serviço */
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem","cliente excluído com sucesso!!")); /* Retorna uma resposta HTTP com status 200 (OK) e uma mensagem indicando que o cliente foi excluído com sucesso */
    }
}
