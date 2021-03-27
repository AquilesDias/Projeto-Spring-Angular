package br.com.dev.Cliente.Clientes.rest;

import br.com.dev.Cliente.Clientes.model.entity.Cliente;
import br.com.dev.Cliente.Clientes.model.entity.ServicoPrestado;
import br.com.dev.Cliente.Clientes.model.repository.ClienteRepository;
import br.com.dev.Cliente.Clientes.model.repository.ServicoPrestadoRepository;
import br.com.dev.Cliente.Clientes.rest.dto.ServicoPrestadoDTO;
import br.com.dev.Cliente.Clientes.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/servicos-prestados")
public class ServicoPrestadoController {

    private final ClienteRepository clienteRepository;
    private final ServicoPrestadoRepository servicoPrestadoRepository;
    private final BigDecimalConverter bigDecimalConverter;

    @ResponseStatus(HttpStatus.CREATED)
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
        servicoPrestado.setValor(bigDecimalConverter.converter(dto.getPreco()));

        return servicoPrestadoRepository.save(servicoPrestado);
    }
}
