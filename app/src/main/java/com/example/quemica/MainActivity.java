package com.example.quemica;
//Desenvolvido por Pedro Costa Barros para a disciplina de Praticas Interdisciplinares no Ensino de Química 2
//https://github.com/pedra42
//barros.pedro.costa@gmail.com
//Julho 2023


//Esta classe estabelece a atividade principal e a tela principal e a interação com a tela de jogo e executa a função de resetar as palavras e pontuação
import androidx.appcompat.app.AppCompatActivity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Arrays;
import android.content.Context;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se conecta a instancia do singleton do banco de palavras
        BancoDePalavras meuBancoDePalavras;
        meuBancoDePalavras = BancoDePalavras.getInstance();

        //Se conecta a instancia do singleton do contador de pontuação
        ContadorDePontuacao meuContadorDePontucao;
        meuContadorDePontucao = ContadorDePontuacao.getInstance();


        //Executa a configuração dos botões do menu
        configuracaoBotaoJogar();
        configuracaoBotaoResetar();

    }

    //Configura o Botão jogar
    private void configuracaoBotaoJogar(){
        Button butaoJogar = (Button) findViewById(R.id.buttonJogar);
        butaoJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Estabelece a Transição entre as Atividades
                Intent intent = new Intent(MainActivity.this, TelaDoJogo.class );
                startActivity(intent);
            }
        });
    }

    private void configuracaoBotaoResetar(){

        Button butaoJogar = (Button) findViewById(R.id.button2);
        butaoJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Se conecta a instancia do singleton do contador de pontuação
                BancoDePalavras meuBancoDePalavras;
                meuBancoDePalavras =BancoDePalavras.getInstance();

                //Substitui o array de trabalho pelo array estável
                meuBancoDePalavras.arrayDeTrabalhoConceitos = Arrays.copyOf(meuBancoDePalavras.ArrayEstavelConceitos, meuBancoDePalavras.ArrayEstavelConceitos.length);

                //Se conecta a instancia do singleton do contador de pontuação
                ContadorDePontuacao meuContadorDePontucao;
                meuContadorDePontucao = ContadorDePontuacao.getInstance();

                //Reseta as variáveis de pontuação da instancia do contador de pontuação
                meuContadorDePontucao.acertos = 0;
                meuContadorDePontucao.erros = 0;
            }
        });
    }


}