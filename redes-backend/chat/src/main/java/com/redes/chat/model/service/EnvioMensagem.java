package com.redes.chat.model.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

import com.redes.chat.dtos.UsuarioDTO;
import com.redes.chat.model.ConfiguracaoServidor;

public class EnvioMensagem {
	
    private String enderecoServidor = ConfiguracaoServidor.ENDERECO.getEndereco();
    private int portaTcp = ConfiguracaoServidor.PORTA_TCP.getPorta();
    private int portaUdp = ConfiguracaoServidor.PORTA_UDP.getPorta();

    public String enviarMensagemTcp(String mensagem) throws IOException {
        try (Socket socket = new Socket(enderecoServidor, portaTcp);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            
            writer.write(mensagem);
            writer.flush();

            return reader.readLine();
        }
    }

    public void enviarMensagemUdp(String mensagem) throws IOException {
        try (DatagramSocket socket = new DatagramSocket()) {
            byte[] buffer = mensagem.getBytes();
            InetAddress address = InetAddress.getByName(enderecoServidor);

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, portaUdp);
            socket.send(packet);
        }
    }

    public String getUsuariosConectados(UsuarioDTO usuario) throws IOException {
        return enviarMensagemTcp(Requests.instance().getRequestUsers(usuario));
    }
    
}
