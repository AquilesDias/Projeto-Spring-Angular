package br.com.dev.Cliente.Clientes.rest;

import br.com.dev.Cliente.Clientes.model.entity.Cliente;
import br.com.dev.Cliente.Clientes.model.entity.ServicoPrestado;
import br.com.dev.Cliente.Clientes.model.repository.ClienteRepository;
import br.com.dev.Cliente.Clientes.model.repository.ServicoPrestadoRepository;
import br.com.dev.Cliente.Clientes.rest.dto.ServicoPrestadoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RequestMapping
@RequiredArgsConstructor
@RestController("api/servico-prestado")
public class ServicoPrestadoController {

    private final ClienteRepository clienteRepository;
    private final ServicoPrestadoRepository servicoPrestadoRepository;

    @PostMapping
    public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto){

        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Integer idCliente = dto.getIdCliente();
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(()
                        -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Cliente inexistente"));

        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData(data);
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setValor();
        return servicoPrestado;
    }
}
