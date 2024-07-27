package com.redes.chat.controllers;

import com.redes.chat.dtos.MensagemDTO;
import com.redes.chat.dtos.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/chat")
public class Controller {

	@Autowired
	private ServicoChat servicoChat;

	@PostMapping("/usuarios")
	public ResponseEntity<?> obterUsuarios(@RequestBody UsuarioDTO usuario) {
		try {
			return ResponseEntity.ok().body(servicoChat.obterUsuarios(usuario));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@PostMapping("/mensagem")
	public ResponseEntity<?> obterMensagem(@RequestBody UsuarioDTO usuario) {
		try {
			return ResponseEntity.ok().body(servicoChat.obterMensagem(usuario));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@PostMapping("/enviar/mensagem")
	public ResponseEntity<?> enviarMensagem(@RequestBody MensagemDTO mensagem) {
		
		try {
			servicoChat.enviarMensagem(mensagem);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}	
}
