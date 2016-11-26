package br.com.estudo.mainTeste;

import br.com.estudo.util.RelatorioNotificacao;

public class MainTeste {

    public static void main(String[] args) {
        try {
            new RelatorioNotificacao().gerar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
