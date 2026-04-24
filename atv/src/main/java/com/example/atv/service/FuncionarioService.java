package com.example.atv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atv.model.FuncionarioModel;
import com.example.atv.repository.FuncionarioRepository;

@Service /* Inserindo a camada de serviço para Funcionarios */
public class FuncionarioService {
    @Autowired /* Injetando o repositório de Funcionarios */
    private FuncionarioRepository funcionarioRepository; /* Variável para acessar os métodos do repositório de Funcionarios */

    public List<FuncionarioModel>listarFuncionarios(){ /* Método para listar todos os funcionarios */
        return funcionarioRepository.findAll(); /* Retorna uma lista de todos os funcionarios cadastrados no banco de dados */
    }

    public FuncionarioModel salvarFuncionarios(FuncionarioModel funcionario){ /* Método para salvar um funcionario */
        if (funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()) { /* Verifica se já existe um funcionario com o mesmo email */
            throw new RuntimeException("Email já existente..."); /* Lança uma exceção caso o funcionario já exista */
        }
        return funcionarioRepository.save(funcionario); /* Salva o funcionario no banco de dados e retorna o funcionario salvo */
    }

    public FuncionarioModel atualizarFuncionarios(Long id, FuncionarioModel funcionario){ /* Método para atualizar um funcionario */
        if (!funcionarioRepository.existsById(id)) { /* Verifica se o funcionario existe antes de atualizar */
            throw new IllegalArgumentException("Funcionario não encontrado,tente novamente!!"); /* Lança uma exceção caso o funcionario não exista */
        }
        funcionario.setId(id); /* Define o ID do funcionario a ser atualizado */
        return funcionarioRepository.save(funcionario); /* Salva as alterações do funcionario no banco de dados e retorna o funcionario atualizado */
    }

    public void deletarFuncionarios(Long id){ /* Método para deletar um funcionario */
        if (!funcionarioRepository.existsById(id)) { /* Verifica se o funcionario existe antes de deletar */
            throw new IllegalArgumentException("Funcionario não encontrado,tente novamente!!"); /* Lança uma exceção caso o funcionario não exista */
        }
        funcionarioRepository.deleteById(id); /* Deleta o funcionario do banco de dados pelo ID */
    }
}
