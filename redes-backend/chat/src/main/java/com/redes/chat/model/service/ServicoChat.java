package com.redes.chat.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.redes.chat.dtos.MensagemDTO;
import com.redes.chat.dtos.TransformDTOService;
import com.redes.chat.dtos.UsuarioDTO;

@Service
public class ServicoChat {

    private EnvioMensagem envioMensagem;

    public ServicoChat() {
        this.envioMensagem = new EnvioMensagem();
    }

	public List<UsuarioDTO> obterUsuarios(UsuarioDTO usuario) throws IOException {
		String usuarios = envioMensagem.getUsuariosConectados(usuario);
		return TransformDTOService.instance().transformToUsuarioDTO(usuarios);
	}

    public MensagemDTO obterMensagem(UsuarioDTO usuario) throws IOException {
        String requisicao = Requests.instance().getRequestObterMensagem(usuario);
        return TransformDTOService.instance().transformToGetMensagemDTO(envioMensagem.enviarMensagemTcp(requisicao));
    }

    public void enviarMensagem(MensagemDTO mensagem) throws IOException {
        String requisicao = Requests.instance().getRequestSendMessage(mensagem);
        envioMensagem.enviarMensagemUdp(requisicao);
    }
}
