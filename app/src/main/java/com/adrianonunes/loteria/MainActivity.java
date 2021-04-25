package com.adrianonunes.loteria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity<txtOpcao> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private boolean flag;
    private int[] vetLoteria =  new int[50];
    private int sorteio;
    private TextView[] texto =  new TextView[50];
    private boolean gravado = false;

    public void geraNumeros(int nSorteado, int nTotal) {
        for (int i = 0; i < nSorteado; i++) {
            flag = true;
            while (flag == true) {
                sorteio = new Random().nextInt(nTotal);
                for (int n = 0; n < nSorteado; n++) {
                    if (sorteio == vetLoteria[n]) {
                        flag = true;
                        break;
                    }
                    else{
                        flag = false;
                    }
                }
            }

            if (flag == false && sorteio != 0) {
                vetLoteria[i] = sorteio;
            }
        }
    }

    public void ordenar(int nSorteados) {
        for(int a = 0; a < nSorteados; a++) {
            for(int b = a + 1; b < nSorteados; b++) {
                if(vetLoteria[a] > vetLoteria[b]) {
                    int auxiliar = vetLoteria[a];
                    vetLoteria[a] = vetLoteria[b];
                    vetLoteria[b] = auxiliar;
                }
            }
        }
    }

    public void gravarExibirNumeros(int nSorteados2) {
        texto[0] = findViewById(R.id.txtResultado1);
        texto[1] = findViewById(R.id.txtResultado2);
        texto[2] = findViewById(R.id.txtResultado3);
        texto[3] = findViewById(R.id.txtResultado4);
        texto[4] = findViewById(R.id.txtResultado5);
        texto[5] = findViewById(R.id.txtResultado6);
        texto[6] = findViewById(R.id.txtResultado7);
        texto[7] = findViewById(R.id.txtResultado8);
        texto[8] = findViewById(R.id.txtResultado9);
        texto[9] = findViewById(R.id.txtResultado10);
        texto[10] = findViewById(R.id.txtResultado11);
        texto[11] = findViewById(R.id.txtResultado12);
        texto[12] = findViewById(R.id.txtResultado13);
        texto[13] = findViewById(R.id.txtResultado14);
        texto[14] = findViewById(R.id.txtResultado15);
        texto[15] = findViewById(R.id.txtResultado16);
        texto[16] = findViewById(R.id.txtResultado17);
        texto[17] = findViewById(R.id.txtResultado18);
        texto[18] = findViewById(R.id.txtResultado19);
        texto[19] = findViewById(R.id.txtResultado20);
        texto[20] = findViewById(R.id.txtResultado21);
        texto[21] = findViewById(R.id.txtResultado22);
        texto[22] = findViewById(R.id.txtResultado23);
        texto[23] = findViewById(R.id.txtResultado24);
        texto[24] = findViewById(R.id.txtResultado25);
        texto[25] = findViewById(R.id.txtResultado26);
        texto[26] = findViewById(R.id.txtResultado27);
        texto[27] = findViewById(R.id.txtResultado28);
        texto[28] = findViewById(R.id.txtResultado29);
        texto[29] = findViewById(R.id.txtResultado30);
        texto[30] = findViewById(R.id.txtResultado31);
        texto[31] = findViewById(R.id.txtResultado32);
        texto[32] = findViewById(R.id.txtResultado33);
        texto[33] = findViewById(R.id.txtResultado34);
        texto[34] = findViewById(R.id.txtResultado35);
        texto[35] = findViewById(R.id.txtResultado36);
        texto[36] = findViewById(R.id.txtResultado37);
        texto[37] = findViewById(R.id.txtResultado38);
        texto[38] = findViewById(R.id.txtResultado39);
        texto[39] = findViewById(R.id.txtResultado40);
        texto[40] = findViewById(R.id.txtResultado41);
        texto[41] = findViewById(R.id.txtResultado42);
        texto[42] = findViewById(R.id.txtResultado43);
        texto[43] = findViewById(R.id.txtResultado44);
        texto[44] = findViewById(R.id.txtResultado45);
        texto[45] = findViewById(R.id.txtResultado46);
        texto[46] = findViewById(R.id.txtResultado47);
        texto[47] = findViewById(R.id.txtResultado48);
        texto[48] = findViewById(R.id.txtResultado49);
        texto[49] = findViewById(R.id.txtResultado50);

        TextView txtOpcao = findViewById(R.id.txtOpcao);
        if (nSorteados2 == 6) {
            txtOpcao.setText("APOSTA: Mega-Sena");
        }
        else if (nSorteados2 == 50) {
            txtOpcao.setText("APOSTA: Lotomania");
        }
        else if (nSorteados2 == 15) {
            txtOpcao.setText("APOSTA: Lotofacil");
        }
        else {
            txtOpcao.setText("APOSTA: Quina");
        }

        for (int i = 0; i < nSorteados2; i++) {
            System.out.println(vetLoteria[i]);
            if(vetLoteria[i] < 10) {
                texto[i].setText(" 0" + vetLoteria[i] + " ");
            }
            else if(vetLoteria[i] > 99) {
                texto[i].setText(" 00 ");
            }
            else {
                texto[i].setText(" " + vetLoteria[i] + " ");
            }
        }
        gravado = true;
    }

    public void limpar(int nLimpar){
        for (int i = 0; i < nLimpar; i++) {
            System.out.println(vetLoteria[i]);
            texto[i].setText("");
            texto[49].setText("");
        }
    }

    public void megaSena(View view) {
        if (gravado) {
            limpar(50);
        }

        geraNumeros(6, 61);

        ordenar(6);

        gravarExibirNumeros(6);
    }

    public void quina(View view) {
        if (gravado) {
            limpar(50);
        }

        geraNumeros(5, 81);

        ordenar(5);

        gravarExibirNumeros(5);
    }

    public void lotoMania(View view) {
        if (gravado) {
            limpar(50);
        }

        geraNumeros(50, 101);

        ordenar(50);

        gravarExibirNumeros(50);
    }

    public void lotoFacil(View view) {
        if (gravado) {
            limpar(50);
        }

        geraNumeros(15, 26);

        ordenar(15);

        gravarExibirNumeros(15);
    }
 }

