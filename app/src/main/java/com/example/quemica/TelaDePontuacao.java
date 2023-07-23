package com.example.quemica;
//Esta classe configura a tela de pontuação.
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaDePontuacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Acessa o singleton da pontuação
        ContadorDePontuacao meuContadorDePontucao;
        meuContadorDePontucao = ContadorDePontuacao.getInstance();

        //Configura os textos e inicializa dos botoes
        setContentView(R.layout.activity_tela_de_pontuacao);
        TextView textoAcertos = (TextView) findViewById(R.id.textView4);
        TextView textoErros = (TextView) findViewById(R.id.textView5);
        textoAcertos.setText("Acertos: "+meuContadorDePontucao.acertos);
        textoErros.setText("Pulados: "+meuContadorDePontucao.erros);
        configuracaoBotaoContinuar();
        configuracaoBotaoMenu();


    }

    //Configura o Botão de Continuar
    private void configuracaoBotaoContinuar(){
        ContadorDePontuacao meuContadorDePontucao;
        meuContadorDePontucao = ContadorDePontuacao.getInstance();
        Button butaoContinuar = (Button) findViewById(R.id.button);
        butaoContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                meuContadorDePontucao.acertos = 0;
                meuContadorDePontucao.erros = 0;
                Intent intent = new Intent(TelaDePontuacao.this, TelaDoJogo.class );
                startActivity(intent);
            }
        });
    }

    //Configura o botãod e voltar ao menu

    private void configuracaoBotaoMenu(){
        ContadorDePontuacao meuContadorDePontucao;
        meuContadorDePontucao = ContadorDePontuacao.getInstance();
        Button butaoMenu = (Button) findViewById(R.id.button3);
        butaoMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                meuContadorDePontucao.acertos = 0;
                meuContadorDePontucao.erros = 0;
                Intent intent = new Intent(TelaDePontuacao.this, MainActivity.class );
                startActivity(intent);
            }
        });
    }
}