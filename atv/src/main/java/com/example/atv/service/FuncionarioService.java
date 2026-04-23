package com.example.atv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atv.model.FuncionarioModel;
import com.example.atv.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<FuncionarioModel>listarFuncionarios(){
        return funcionarioRepository.findAll();
    }

    public FuncionarioModel salvarFuncionarios(FuncionarioModel funcionario){
        if (funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()) {
            throw new RuntimeException("Funcionario já existente...");
        }
        return funcionarioRepository.save(funcionario);
    }

    public FuncionarioModel atualizarFuncionarios(Long id, FuncionarioModel funcionario){
        if (!funcionarioRepository.existsById(id)) {
            throw new IllegalArgumentException("Funcionario não encontrado,tente novamente!!");
        }
        funcionario.setId(id);
        return funcionarioRepository.save(funcionario);
    }

    public void deletarFuncionarios(Long id){
        if (!funcionarioRepository.existsById(id)) {
            throw new IllegalArgumentException("Funcionario não encontrado,tente novamente!!");
        }
        funcionarioRepository.deleteById(id);
    }
}
