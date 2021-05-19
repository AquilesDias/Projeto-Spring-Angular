package br.com.dev.Cliente.Clientes.model.repository;

import br.com.dev.Cliente.Clientes.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
