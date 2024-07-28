package com.redes.chat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redes.chat.dtos.MensagemDTO;
import com.redes.chat.dtos.UsuarioDTO;
import com.redes.chat.model.service.ServicoChat;

@RestController
@RequestMapping("/chat")
public class Controller {

	@Autowired
	private ServicoChat servicoChat;

	@GetMapping("/usuarios")
	public ResponseEntity<?> obterUsuarios(@RequestBody UsuarioDTO usuario) {
		try {
			return ResponseEntity.ok().body(servicoChat.obterUsuarios(usuario));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@GetMapping("/mensagem")
	public ResponseEntity<?> obterMensagem(@RequestBody UsuarioDTO usuario) {
		try {
			return ResponseEntity.ok().body(servicoChat.obterUsuarios(usuario));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@PostMapping("/mensagem")
	public ResponseEntity<?> enviarMensagem(@RequestBody MensagemDTO mensagem) {
		
		try {
			servicoChat.enviarMensagem(mensagem);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}	
}
