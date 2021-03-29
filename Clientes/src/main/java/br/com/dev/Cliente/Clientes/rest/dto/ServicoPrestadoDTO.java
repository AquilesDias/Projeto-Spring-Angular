package br.com.dev.Cliente.Clientes.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ServicoPrestadoDTO {

    @NotEmpty(message = "O campo da descrição é obrigatório, amigo.")
    private String descricao;

    @NotEmpty(message = "O campo do preço é obrigatório")
    private String preco;

    @NotEmpty(message = "O campo data é obrigatório, amigo.")
    private String data;

    @NotNull(message = "O campo do cliente é obrigatório, amigo.")
    private Integer idCliente;
}
