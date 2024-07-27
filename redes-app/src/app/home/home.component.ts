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
  usuariosSistema: usuario[] = [
    {
      userId: 4732,
      username: "Ana Carolina Cipriani dos Santos",
      passwd: "ihuyt"
    },
    {
      userId: 9518,
      username: "Ari Elias da Silva Júnior",
      passwd: "sbxex"
    },
    {
      userId: 5037,
      username: "Eduardo Silverio Lyra",
      passwd: "bysse"
    },
    {
      userId: 2222,
      username: "Franciso Adell Péricas",
      passwd: "adell"
    },
    {
      userId: 1211,
      username: "Gabriel Eduardo Pereira",
      passwd: "mkcd"
    },
    {
      userId: 3703,
      username: "Haziel Albuquerque Netto",
      passwd: "sqcbm"
    },
    {
      userId: 4452,
      username: "Luan Lavandoski Guarnieri",
      passwd: "kbfba"
    },
    {
      userId: 5228,
      username: "Luigi Garcia Marchetti",
      passwd: "nywfg"
    },
    {
      userId: 2669,
      username: "Maria Eduarda Krutzsch",
      passwd: "mpdyn"
    },
    {
      userId: 1974,
      username: "Rodrigo Kapulka Franco",
      passwd: "wcchs"
    },
    {
      userId: 8269,
      username: "Rossana Rocha da Silva",
      passwd: "yfdmf"
    },
    {
      userId: 2162,
      username: "Victor do Amaral",
      passwd: "vqnnt"
    }

  ]

  constructor(private redesService: RedesService) {}

  ngOnInit(): void {
    // a cada 5 seg fazer requisição para buscar usuários ativos
    interval(5000).subscribe(func => {
      if (this.isValid()) {
        this.getUsuarios();
      }
    });
    // a cada 4 seg fazer requisição para buscar mensagens
   interval(4000).subscribe(func => {
      if (this.isValid()) {
        this.getMensagens();
      }
   });
  }

  isValid() {
    return this.usuarioLogado.userId && this.usuarioLogado.username && this.usuarioLogado.passwd
  }

  getUsuarios() {
    this.usuarios = this.redesService.getUsers(this.usuarioLogado);
    this.usuarios.subscribe(resp => console.log(resp));
  }

  getMensagens() {
    this.mensagensRecebidas = this.redesService.getMessages(this.usuarioLogado);
  }

  enviarMsg() {
    // só envia se selecionou user e digitou msg
    if (this.mensagemEnviar.destinationId && this.mensagemEnviar.msg != '' && this.isValid()) {
      this.redesService.enviarMensagem(this.mensagemEnviar)
        .subscribe(resp => {
          if (resp) {
                window.alert("Mensagem enviada!");
            }
        })
    } else {
      window.alert("Faça o login!");
    }
  }
}
