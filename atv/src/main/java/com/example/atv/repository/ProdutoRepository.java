package com.example.atv.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.atv.model.ProdutoModel;


@Repository /*Inserindo o repositório para Produtos */
public interface ProdutoRepository extends JpaRepository<ProdutoModel,Long>{
    Optional<ProdutoModel>findByLote(String lote); /* Método para encontrar um produto pelo lote */
}
