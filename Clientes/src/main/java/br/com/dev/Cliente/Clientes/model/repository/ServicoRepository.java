package br.com.dev.Cliente.Clientes.model.repository;

import br.com.dev.Cliente.Clientes.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
