package com.spring_database_connection.services;

import com.spring_database_connection.models.Clientes;
import com.spring_database_connection.repositories.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    public Clientes salvarCliente(Clientes cliente){
        cliente.setData_cadastro(Instant.now());
        return clienteRepository.save(cliente);
    }

    public List<Clientes> listarClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Clientes> buscarCliente(Long id) {
        return clienteRepository.findById(id);
    }

    public Clientes editarCliente(Long id, Clientes cliente){
        Clientes clienteParaAlterar = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        clienteParaAlterar.setNome(cliente.getNome());
        clienteParaAlterar.setEmail(cliente.getEmail());
        clienteParaAlterar.setEndereco(cliente.getEndereco());

        return clienteRepository.save(clienteParaAlterar);
    }

    public void deletarCliente(Long id){
        clienteRepository.deleteById(id);
    }

}
