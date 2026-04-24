package com.example.atv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atv.model.ClienteModel;
import com.example.atv.repository.ClienteRepository;

@Service /* Inserindo a camada de serviço para Clientes */
public class ClienteService {
    @Autowired /* Injetando o repositório de Clientes */
    private ClienteRepository clienteRepository;

    public List<ClienteModel>listarClientes(){ /* Método para listar todos os clientes */
        return clienteRepository.findAll(); // Retorna uma lista de todos os clientes cadastrados
    }

    public ClienteModel salvarClientes(ClienteModel cliente){ /* Método para salvar um cliente */
        if (clienteRepository.findByEmail(cliente.getEmail()).isPresent()) { /* Verifica se já existe um cliente com o mesmo email */
            throw new RuntimeException("Este Email já existe,tente novamente..."); /* Lança uma exceção caso o cliente já exista */
        }
        return clienteRepository.save(cliente); /* Salva o cliente no banco de dados e retorna o cliente salvo */
    }

    public ClienteModel atualizarClientes(Long id, ClienteModel cliente){ /* Método para atualizar um cliente */
        if (!clienteRepository.existsById(id)) { /* Verifica se o cliente existe antes de atualizar */
            throw new IllegalArgumentException("Cliente não encontrado,tente novamente!!"); /* Lança uma exceção caso o cliente não exista */
        }
        cliente.setId(id); /* Define o ID do cliente a ser atualizado */
        return clienteRepository.save(cliente); /* Salva as alterações do cliente no banco de dados e retorna o cliente atualizado */
    }

    public void deletarClientes(Long id){ /* Método para deletar um cliente */
        if (!clienteRepository.existsById(id)) { /* Verifica se o cliente existe antes de deletar */
            throw new IllegalArgumentException("Cliente não encontrado,tente novamente!!"); /* Lança uma exceção caso o cliente não exista */
        }
        clienteRepository.deleteById(id); /* Deleta o cliente do banco de dados pelo ID */
    }
}
