package com.example.atv.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BemVindo {

    public String bemVindo(){
        return "Seja Bem vindo!";
    }
}
