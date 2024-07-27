import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { mensagem } from '../models/mensagem';
import { usuario } from '../models/usuario';

@Injectable({
  providedIn: 'root'
})
export class RedesService {

  constructor(private httpClient: HttpClient) { }

  private urlApi = "http://localhost:8080/chat";

  getUsers(usuario: usuario) {
    return this.httpClient.post<usuario[]>(`${this.urlApi}/usuarios`, usuario);
  }

  getMessages(usuario: usuario) {
    return this.httpClient.post<mensagem[]>(`${this.urlApi}/mensagem`, usuario);
  }

  enviarMensagem(mensagem: mensagem) {
    return this.httpClient.post<mensagem[]>(`${this.urlApi}/enviar/mensagem`, mensagem);
  }
  
}
