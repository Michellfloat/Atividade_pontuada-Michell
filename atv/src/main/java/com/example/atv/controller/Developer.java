package com.example.atv.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dev")
public class Developer {
    public String developer(){
        return "Michell Silva Santos";
    }
}
