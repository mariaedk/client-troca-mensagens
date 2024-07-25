package com.redes.chat.model.service;

import com.redes.chat.dtos.MensagemDTO;
import com.redes.chat.dtos.UsuarioDTO;
import com.redes.chat.model.InvalidUserException;

public final class Requests {

	private static final InvalidUserException EXCEPTION_INVALID_USER = new InvalidUserException("Usuário sem valor");
	private static final String GET_USERS_REQUEST_FORMAT = "GET USERS %s:%s\n";
	private static final String GET_MESSAGE_REQUEST_FORMAT = "GET MESSAGE %s:%s\n";
	private static final String SEND_MESSAGE_REQUEST_FORMAT = "SEND MESSAGE %s:%s:%s:%s\n";

    private Requests() {}

    public static Requests instance() {
        return new Requests();
    }

    public String getRequestUsers(UsuarioDTO usuario) {
        if (usuario == null) {
            throw EXCEPTION_INVALID_USER;
        }
        return String.format(GET_USERS_REQUEST_FORMAT, usuario.getUserId(), usuario.getPasswd());
    }

    public String getRequestObterMensagem(UsuarioDTO usuario) {
        if (usuario == null) {
            throw EXCEPTION_INVALID_USER;
        }
        return String.format(GET_MESSAGE_REQUEST_FORMAT, usuario.getUserId(), usuario.getPasswd());
    }

    public String getRequestSendMessage(MensagemDTO mensagem) {
        if (mensagem == null || mensagem.getUsuario() == null) {
            throw EXCEPTION_INVALID_USER;
        }
        String userId = mensagem.getUsuario().getUserId();
        String userPasswd = mensagem.getUsuario().getPasswd();
        return String.format(SEND_MESSAGE_REQUEST_FORMAT, userId, userPasswd,  mensagem.getDestinationId(), mensagem.getMsg());
    }

}
