package com.redes.chat.model;

public enum ConfiguracaoServidor {
    ENDERECO("larc.inf.furb.br"),
    PORTA_TCP(1012),
    PORTA_UDP(1011);

    private final String endereco;
    private final int porta;

    ConfiguracaoServidor(String endereco) {
        this.endereco = endereco;
        this.porta = -1;
    }

    ConfiguracaoServidor(int porta) {
        this.endereco = null;
        this.porta = porta;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getPorta() {
        return porta;
    }
}