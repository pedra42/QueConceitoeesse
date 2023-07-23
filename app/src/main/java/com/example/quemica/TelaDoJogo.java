package com.example.quemica;


//Esta classe estabelece a atividade da tela do jogo, onde as ações de passar ou acertar são realizadas e a pontuação é registrada

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.widget.TextView;

import java.util.Arrays;

public class TelaDoJogo extends AppCompatActivity {



    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_do_jogo);
        TextView textoConceito = (TextView) findViewById(R.id.textView3);
        TextView textoCronometro = (TextView) findViewById(R.id.textView);

        //São geradas as instancias dos singletons
        BancoDePalavras meuBancoDePalavras;
        meuBancoDePalavras = BancoDePalavras.getInstance();

        ContadorDePontuacao meuContadorDePontucao;
        meuContadorDePontucao = ContadorDePontuacao.getInstance();

        // Aqui são estabelecidos parametros para detectar a passagem do dedo na tela.
        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            private static final int SWIPE_THRESHOLD = 100;
            private static final int SWIPE_VELOCITY_THRESHOLD = 100;

            //Esta variável é utilizada para que haja a execução de apenas um cronometro.
            boolean cronometroRodando=false;
            //Estas variáveis são utilizadas para corrigir a pontuação
            boolean firstSwipe = true;
            boolean lastSwipe = true;
            String x = "";

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                //Esta função roda quando o arreste do dedo na tela é detectado
                //Quando isto acontece o cronometro é iniciado.
                if (cronometroRodando== false){
                    cronometroRodando = true;
                    new CountDownTimer(90000, 1000) {

                        public void onTick(long millisUntilFinished) {
                            textoCronometro.setText("" + millisUntilFinished / 1000);

                            // logic to set the EditText could go here
                        }
                        //Ao terminar o cronometro e variável de primeiro arreste são resetados e se passa para a tela de pontuação
                        public void onFinish() {
                            textoCronometro.setText("Acabou!");
                            cronometroRodando = false;
                            firstSwipe = true;
                            Intent intent = new Intent(TelaDoJogo.this, TelaDePontuacao.class );
                            startActivity(intent);
                        }

                    }.start();
                }

                //Este trecho de código não é meu e eu nao entendo bem, mas ele diferencia entre o arrastar para cima e para baixo
                //Existem alguns system.out para ajudar a debuggar
                float diffY = e2.getY() - e1.getY();
                if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {

                    if (diffY > 0) {
                        // Swipe down - Arraste para Baixo
                        System.out.println(Arrays.toString(meuBancoDePalavras.arrayDeTrabalhoConceitos));
                        if(meuBancoDePalavras.arrayDeTrabalhoConceitos.length>0) {
                            //escolhe uma palavara da lista de trabalho
                            x = meuBancoDePalavras.retornaAleatorioDoArray(meuBancoDePalavras.arrayDeTrabalhoConceitos);
                            System.out.println(x);
                            //manda a palavra para tela
                            textoConceito.setText(x);

                            //se for a primeira arrastada o ponto não é contado, isso é necessário para corrigir a pontuação
                            if(firstSwipe == true){
                                firstSwipe = false;
                            }
                            else
                            {
                                //Depois da primeira passagem o arreste conta como um pulo
                                meuContadorDePontucao.erros++;
                            }


                        }
                        //Se a lista de trabalha acaba este texto é mandado pra tela
                        else{
                            textoConceito.setText("SEM MAIS CONCEITOS ");

                        }
                        System.out.println(Arrays.toString(meuBancoDePalavras.arrayDeTrabalhoConceitos));
                    } else {
                        // Swipe up - Arraste para Cima
                        System.out.println(Arrays.toString(meuBancoDePalavras.arrayDeTrabalhoConceitos));
                        if(meuBancoDePalavras.arrayDeTrabalhoConceitos.length>0) {
                            //Aqui existe a possibilidade de uma palavra já estar na tela, se já estiver então ela é deletada do array de trabalho
                            if(x != null){meuBancoDePalavras.arrayDeTrabalhoConceitos = meuBancoDePalavras.deletaValorDoArray(meuBancoDePalavras.arrayDeTrabalhoConceitos, x);
                            }
                            //Uma palavra aleatória é escolhida
                            x = meuBancoDePalavras.retornaAleatorioDoArray(meuBancoDePalavras.arrayDeTrabalhoConceitos);
                            System.out.println(x);
                            //Uma palavra aleatória é mandada pra tela
                            textoConceito.setText(x);
                            //Se for o primeiro arraste o ponto não é contado
                            if(firstSwipe == true){
                                firstSwipe = false;
                            }
                            //Depois do primeiro arraste os pontos são contados
                            else{
                                //meuBancoDePalavras.arrayDeTrabalhoConceitos = meuBancoDePalavras.deletaValorDoArray(meuBancoDePalavras.arrayDeTrabalhoConceitos, x);
                                meuContadorDePontucao.acertos++;
                            }
                        }

                        //O texto caso o array de trabalho tenha acabado.
                        else{
                            textoConceito.setText("SEM MAIS CONCEITOS ");


                        }
                        System.out.println(Arrays.toString(meuBancoDePalavras.arrayDeTrabalhoConceitos));
                    }
                    return true;

                }

                return false;

            }
        });
    }

    //Não sei o que isso faz, faz parte do código de detecção do arraste
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);

    }


}
