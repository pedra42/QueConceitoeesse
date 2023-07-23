


package com.example.quemica;


//Esta classe utiliza padrão singleton para gerar um único bando de palavras para toda a aplicação


import java.util.Arrays;
import java.util.Random;

public class BancoDePalavras {


        private static BancoDePalavras objetoBanco;

        //Contrutor da classe é privado e nao pode ser utilizado fora da classe. Não sei exatamente o que quer dizer, mas faz parte do singleton
        private BancoDePalavras(){}

    //método get instance do singleton, é a parte mais importante do singleton, se não existe uma instancia ele a cria, se ela existe ele somente a retorna
    public static BancoDePalavras getInstance() {

        // create object if it's not already created
        if(objetoBanco == null) {
            objetoBanco = new BancoDePalavras();
        }

        // returns the singleton object
        return objetoBanco;
    }


    //Função que escolhe um item aleatório do array, é utilizado para escolher as palavras que aparecem durante o jogo
    public String retornaAleatorioDoArray(String[] array) {
        int posicaoAleatoria = new Random().nextInt(array.length);
        String resposta = array[posicaoAleatoria];
        return resposta;
    }

    //Este método percorre o array e deleta o primeiro item correspondente que encontrar, retorna um novo array.
    //Ele é utilizado para atualizar o array de trabalho durante o jogo
    public String[] deletaValorDoArray(String[] array, String valor) {
        int posicaoAleatoria = new Random().nextInt(array.length);
        String[] novoArray = new String[array.length - 1];
        try {
            for (int i = 0, k = 0; i < array.length; i++) {
                if (array[i] != valor) {
                    novoArray[k] = array[i];
                    k++;
                }
            }
            return novoArray;
        }
        catch(Exception e) {
            return array;
        }
        }



        //Este é o "array estável" que serve como original, do qual o array de trabalho é uma cópia que é modificada durante a execução do jogo
    String[] ArrayEstavelConceitos = {"Densidade", "Temperatura", "Entropia", "Pressão", "Força", "Trabalho",
            "Energia", "Elétron", "Próton", "Neutron", "Isótopo","Orbital", "Modelo de Rutheford-Borh", "Modelo de Dalton", "Modelo de Thomson",
    "Ácido", "Base", "Ácido de Lewis", "Sal", "Óxido", "Ligação Iônica", "Ligação Metálica", "Ligação Covalente", "Interação dipolo-dipolo",
    "Interação Dipolo - Dipolo Induzido", "Ligação de Hidrogênio", "Eletronegatividade", "Energia de Ionização",
    "Oxidação", "Redução", "Cátion", "Ânion", "Íon", "Oxigênio", "Nitrogênio","Carbono","Hidrogênio","Número Atômico",
    "Massa Atômica", "Massa", "Mol", "Concentração Molar", "Estado Gasoso", "Estado Líquido", "Estado Sólido", "Molécula",
    "Pressão Atmosférica", "Pressão de Vapor", "Calor","Elemento", "Raio Atômico", "Halogênios", "Calcogênios", "Metais Alcalinos",
    "Metais Alcalinos Terrosos", "Alotropia", "Terras Raras", "Metais de Transição", "Gás Nobre", "Reatividade", "Reação Química",
    "Ebulição", "Solidificação", "Sublimação", "Destilação", "Extração", "Cromatografia", "Gravimetria", "Becker", "Pipeta", "Pisseta",
    "Bureta", "Proveta", "Erlenmeyer", "Kitasato", "Balão de Vidro", "Tubo de Ensaio", "Pera", "Termômetro", "Barômetro", "Centrífuga", "Mufla",
    "Agitador Magnético", "Ponto Triplo", "Combustão", "Neutralização", "pH", "pOH", "Sólido Cristalino", "Polaridade", "Estado de Transição",
    "Energia de Ativação", "Catalisador", "Álcool", "Éter", "Ester", "Acetona", "Aldeído", "Ácido Carboxílico", "Amina", "Amida", "Aminoácido",
    "Fenol", "Micela", "Insaturação", "Ressonância", "Estabilidade",  "Composto Aromático", "Cadinho", "Solvente", "Soluto", "Analito", "Bastão de Vidro",
            "Balança", "Capela", "Cátodo", "Ânodo", " Indicador Ácido-Base", "Cobre", "Ouro", "Prata", "Ferro", "Lítio", "Potássio","Tabela Periódica",
     "Benzeno", ""
    };
        //Aqui é estabelecido o array de trabalho, que é uma cópia do array estável
    String[] arrayDeTrabalhoConceitos = Arrays.copyOf(ArrayEstavelConceitos, ArrayEstavelConceitos.length);
    }

