package com.example.atv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.atv.model.EntregadorModel;
import com.example.atv.repository.EntregadorRepository;

@Service
public class EntregadorService {
    @Autowired
    private EntregadorRepository EntregadorRepository;

    public List<EntregadorModel>listarEntregadores(){
        return EntregadorRepository.findAll();
    }

    public EntregadorModel salvarEntregadores(EntregadorModel entregador){
        if (EntregadorRepository.findByEmail(entregador.getEmail()).isPresent()) {
            throw new RuntimeException("entregador já existente...");
        }
        return EntregadorRepository.save(entregador);
    }

    public EntregadorModel atualizarEntregadores(Long id, EntregadorModel entregador){
        if (!EntregadorRepository.existsById(id)) {
            throw new IllegalArgumentException("entregador não encontrado,tente novamente!!");
        }
        entregador.setId(id);
        return EntregadorRepository.save(entregador);
    }

    public void deletarEntregadores(Long id){
        if (!EntregadorRepository.existsById(id)) {
            throw new IllegalArgumentException("entregador não encontrado,tente novamente!!");
        }
        EntregadorRepository.deleteById(id);
    }
}
