package com.example.atv.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.atv.model.EntregadorModel;


@Repository /*Inserindo o repositório para Entregadores */
public interface EntregadorRepository extends JpaRepository<EntregadorModel,Long>{
    Optional<EntregadorModel>findByEmail(String email); /* Método para encontrar um entregador pelo email */
}
