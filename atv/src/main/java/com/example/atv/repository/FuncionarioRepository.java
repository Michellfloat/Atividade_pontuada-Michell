package com.example.atv.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.atv.model.FuncionarioModel;


@Repository /*Inserindo o repositório para Funcionarios */
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel,Long>{
    Optional<FuncionarioModel>findByEmail(String email); /* Método para encontrar um funcionario pelo email */
}
