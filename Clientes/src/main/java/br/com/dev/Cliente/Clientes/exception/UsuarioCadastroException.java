package br.com.dev.Cliente.Clientes.exception;

public class UsuarioCadastroException extends RuntimeException {

    public UsuarioCadastroException(String login){
        super("Usuário " +login+ " já cadastrado!");
    }
}
