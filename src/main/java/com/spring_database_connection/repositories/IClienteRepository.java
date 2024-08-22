package com.spring_database_connection.repositories;

import com.spring_database_connection.models.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Clientes, Long> {

}
