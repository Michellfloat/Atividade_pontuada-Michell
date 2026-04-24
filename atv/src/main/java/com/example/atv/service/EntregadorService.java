package com.example.atv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.atv.model.EntregadorModel;
import com.example.atv.repository.EntregadorRepository;

@Service /* Inserindo a camada de serviço para Entregadores */
public class EntregadorService {
    @Autowired /* Injetando o repositório de Entregadores */
    private EntregadorRepository EntregadorRepository;

    public List<EntregadorModel>listarEntregadores(){ /* Método para listar todos os entregadores */
        return EntregadorRepository.findAll(); /* Retorna uma lista de todos os entregadores cadastrados */
    }

    public EntregadorModel salvarEntregadores(EntregadorModel entregador){ /* Método para salvar um entregador */
        if (EntregadorRepository.findByEmail(entregador.getEmail()).isPresent()) { /* Verifica se já existe um entregador com o mesmo email */
            throw new RuntimeException("Email já existente..."); /* Lança uma exceção caso o entregador já exista */
        }
        return EntregadorRepository.save(entregador); /* Salva o entregador no banco de dados e retorna o entregador salvo */
    }

    public EntregadorModel atualizarEntregadores(Long id, EntregadorModel entregador){ /* Método para atualizar um entregador */
        if (!EntregadorRepository.existsById(id)) { /* Verifica se o entregador existe antes de atualizar */
            throw new IllegalArgumentException("entregador não encontrado,tente novamente!!"); /* Lança uma exceção caso o entregador não exista */
        }
        entregador.setId(id); /* Define o ID do entregador a ser atualizado */
        return EntregadorRepository.save(entregador); /* Salva as alterações do entregador no banco de dados e retorna o entregador atualizado */
    }

    public void deletarEntregadores(Long id){ /* Método para deletar um entregador */
        if (!EntregadorRepository.existsById(id)) { /* Verifica se o entregador existe antes de deletar */
            throw new IllegalArgumentException("entregador não encontrado,tente novamente!!"); /* Lança uma exceção caso o entregador não exista */
        } 
        EntregadorRepository.deleteById(id); /* Deleta o entregador do banco de dados pelo ID */
    }
}
