package br.com.dev.Cliente.Clientes.model.repository;

import br.com.dev.Cliente.Clientes.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByUsername(String username);

    boolean existsByUserName(String username);
}
