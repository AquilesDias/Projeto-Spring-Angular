package br.com.dev.Cliente.Clientes.rest;

import br.com.dev.Cliente.Clientes.exception.UsuarioCadastroException;
import br.com.dev.Cliente.Clientes.model.entity.Usuario;
import br.com.dev.Cliente.Clientes.model.repository.UsuarioRepository;
import br.com.dev.Cliente.Clientes.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario){

        try {
            usuarioService.salvar(usuario);
        } catch ( UsuarioCadastroException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


}
