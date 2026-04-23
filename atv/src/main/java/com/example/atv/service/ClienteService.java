package com.example.atv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atv.model.ClienteModel;
import com.example.atv.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteModel>listarClientes(){
        return clienteRepository.findAll();
    }

    public ClienteModel salvarClientes(ClienteModel cliente){
        if (clienteRepository.findByEmail(cliente.getEmail()).isPresent()) {
            throw new RuntimeException("Cliente já existente...");
        }
        return clienteRepository.save(cliente);
    }

    public ClienteModel atualizarClientes(Long id, ClienteModel cliente){
        if (!clienteRepository.existsById(id)) {
            throw new IllegalArgumentException("Cliente não encontrado,tente novamente!!");
        }
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    public void deletarClientes(Long id){
        if (!clienteRepository.existsById(id)) {
            throw new IllegalArgumentException("Cliente não encontrado,tente novamente!!");
        }
        clienteRepository.deleteById(id);
    }
}
