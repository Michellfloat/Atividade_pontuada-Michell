package com.example.atv.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice /* Inserindo a camada de tratamento global de exceções para a aplicação */
public class GlobalException {
    @ExceptionHandler(RuntimeException.class)ResponseEntity<Map<String,Object>>runtimeException(RuntimeException error){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("mensagem",error.getMessage()));
    } /* Método para tratar exceções do tipo RuntimeException, retorna uma resposta HTTP com status 409 (Conflict) e uma mensagem indicando o erro ocorrido */

    @ExceptionHandler(IllegalArgumentException.class)ResponseEntity<Map<String,Object>>illegalArgumentException(IllegalArgumentException error){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("mensagem",error.getMessage()));
    } /* Método para tratar exceções do tipo IllegalArgumentException, retorna uma resposta HTTP com status 400 (Bad Request) e uma mensagem indicando o erro ocorrido */
}
