package com.example.quemica;
//Esta classe é uma classe singleton e é utilizada como objeto principal de controle da pontuação do jogo
public class ContadorDePontuacao {

    // variáveis inteiras que guardam a pontuação durante o jogo
    int acertos=0;
    int erros=0;

    //O resto do código é a estrutura padrão de um singleton
    private static ContadorDePontuacao objetoContador;

    private ContadorDePontuacao(){}

    public static ContadorDePontuacao getInstance() {

        // create object if it's not already created
        if(objetoContador == null) {
            objetoContador = new ContadorDePontuacao();
        }

        // returns the singleton object
        return objetoContador;
    }

}
