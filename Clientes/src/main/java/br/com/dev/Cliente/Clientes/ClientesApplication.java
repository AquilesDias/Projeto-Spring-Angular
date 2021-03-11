package br.com.dev.Cliente.Clientes;

import br.com.dev.Cliente.Clientes.model.entity.Cliente;
import br.com.dev.Cliente.Clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientesApplication {

	    @Autowired ClienteRepository clienteRepository;

		@Bean
		public CommandLineRunner run(@Autowired ClienteRepository clienteRepository){
		return args -> {
			Cliente cliente = Cliente.builder()
					.cpf("45317828791")
					.nome("Musk")
					.build();
			clienteRepository.save(cliente);
		 };
		}

	public static void main(String[] args) {

		SpringApplication.run(ClientesApplication.class, args);
	}
}
