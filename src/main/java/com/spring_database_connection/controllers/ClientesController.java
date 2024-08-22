package com.spring_database_connection.controllers;

import com.spring_database_connection.models.Clientes;
import com.spring_database_connection.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public List<Clientes> listarUsuarios() {
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public Optional<Clientes> buscarUsuario(@PathVariable("id") Long id) {
        return clienteService.buscarCliente(id);
    }

    @PostMapping
    public Clientes cadastrarUsuario(@RequestBody Clientes cliente){
        return clienteService.salvarCliente(cliente);
    }

    @PutMapping("/{id}")
    public Clientes editarUsuario(@PathVariable("id") Long id, @RequestBody Clientes cliente){
        return clienteService.editarCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable("id") Long id){
        clienteService.deletarCliente(id);
    }

}
