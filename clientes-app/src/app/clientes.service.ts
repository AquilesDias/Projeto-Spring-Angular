import { Injectable } from '@angular/core';
import { Cliente } from './clientes/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  constructor() { }

  getCliente(): Cliente{
    let cliente : Cliente = new Cliente();
    cliente.nome = "Aquiles";
    cliente.cpf = "1345678955";
    return cliente;
  }
}
