package br.com.dev.Cliente.Clientes.model.repository;

import br.com.dev.Cliente.Clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
