package com.example.atv.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController /* Inserindo a camada de controle para o desenvolvedor */
@RequestMapping("/dev") /* Define o endpoint base para as operações relacionadas ao desenvolvedor */
public class Developer { 
    public String developer(){ /* Método para retornar o nome do desenvolvedor */
        return "Michell Silva Santos"; /* Retorna o nome do desenvolvedor como resposta */
    }
}
