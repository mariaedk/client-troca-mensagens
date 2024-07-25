import { Component, OnInit } from '@angular/core';
import { RedesService } from '../service/redes.service';
import { mensagem } from '../models/mensagem';
import { Observable, Subject, interval } from 'rxjs';
import { usuario } from '../models/usuario';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  usuarioLogado: usuario = {};
  usuarios = new Observable<usuario[]>();
  mensagemEnviar: mensagem = {};
  mensagensRecebidas = new Observable<mensagem[]>();

  constructor(private redesService: RedesService) {}

  ngOnInit(): void {
    interval(2000).subscribe(func => {
      this.getUsuarios();
    });
    // a cada 6 seg fazer requisição
   interval(6000).subscribe(func => {
      this.getMensagens();
   });
  }

  getUsuarios() {
    this.usuarios = this.redesService.getUsers(this.usuarioLogado);
  }

  getMensagens() {
    this.mensagensRecebidas = this.redesService.getMessages(this.usuarioLogado);
  }

  enviarMsg() {
    // só envia se selecionou user e digitou msg
    if (this.mensagemEnviar.destinationId && this.mensagemEnviar.msg != '') {
      this.redesService.enviarMensagem(this.mensagemEnviar)
        .subscribe(resp => {
          if (resp) {
                window.alert("Mensagem enviada!");
            }
        })
    }
  }



}
