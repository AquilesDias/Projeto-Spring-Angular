import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

import { Cliente } from './clientes/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  apiURL: string = environment.apiUrlBase + '/api/clientes';

  constructor(private http: HttpClient) { 
  
  }
  
  salvar( cliente: Cliente ): Observable<Cliente>{   
    return this.http.post<Cliente>(`${this.apiURL}` , cliente);
  }

  atualizar(cliente : Cliente ) : Observable<any>{
    return this.http.put<Cliente>(`${this.apiURL}/${cliente.id}`, cliente); 
  }

  getClientes() : Observable<Cliente[]>{
    return this.http.get<Cliente[]>(this.apiURL);
  }

  getClientesById(id: number) : Observable<Cliente>{
    return this.http.get<Cliente>(`${this.apiURL}/${id}`)
  } 

  deletar(cliente : Cliente): Observable<any>{
    return this.http.delete<any>(`${this.apiURL}/${cliente.id}`)
  }

}
