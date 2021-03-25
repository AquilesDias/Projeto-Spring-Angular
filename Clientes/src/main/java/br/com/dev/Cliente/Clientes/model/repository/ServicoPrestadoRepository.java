package br.com.dev.Cliente.Clientes.model.repository;

import br.com.dev.Cliente.Clientes.model.entity.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer> {
}
