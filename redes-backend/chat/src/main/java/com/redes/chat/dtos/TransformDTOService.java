package com.redes.chat.dtos;

import java.util.ArrayList;
import java.util.List;

public class TransformDTOService {

    private TransformDTOService() {}

    public static TransformDTOService instance() {
        return new TransformDTOService();
    }

    public List<UsuarioDTO> transformToUsuarioDTO(String response) {
        String[] parts = response.split(":");
        List<UsuarioDTO> users = new ArrayList<>();
        
        for (int i = 0; i < parts.length; i += 3) {
            UsuarioDTO user = new UsuarioDTO();
            user.setUserId(parts[i]);
            user.setUsername(parts[i + 1]);
            user.setWins(Integer.parseInt(parts[i + 2]));
            users.add(user);
        }
        return users;
    }
    
    /**
     * Recebe o retorno do servidor e transforma em {@link MensagemDTO}
     * 
     * @param retorno do servidor
     * @return a mensgem com o id de quem enviou e a mensagem
     */
    public MensagemDTO transformToGetMensagemDTO(String response) {
        String[] parts = response.split(":", 2);

        MensagemDTO mensagem = new MensagemDTO();
        mensagem.setDestinationId(parts[0]);
        mensagem.setMsg(parts.length > 1 ? parts[1] : "");

        return mensagem;
    }

}
