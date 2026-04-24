package com.example.atv.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController /* Inserindo a camada de controle para a mensagem de boas-vindas */
@RequestMapping("/") /* Define o endpoint base para as operações relacionadas à mensagem de boas-vindas */
public class BemVindo {

    public String bemVindo(){ /* Método para retornar a mensagem de boas-vindas */
        return "Seja Bem vindo!"; /* Retorna a mensagem de boas-vindas como resposta */
    }
}
