package com.example.atv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

    /*Criando Tabela para Produtos */

@Entity
@Table(name = "tabela_produtos")
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    /* ID do produto */

    private String nome;

    @Column(unique = true, nullable = false)
    private String lote;
    private String validade;
    private String categoria;
    private int quantidade;
    
    /* Construtores */
    public ProdutoModel() {
    }

    public ProdutoModel(Long id, String nome, String lote, String validade, String categoria, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.lote = lote;
        this.validade = validade;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    /* Getters e Setters */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    
}
