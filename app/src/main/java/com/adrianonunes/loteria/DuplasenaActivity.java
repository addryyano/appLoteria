    package com.adrianonunes.loteria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DuplasenaActivity extends MainActivity {

    private EditText qntText;
    private Button buttonduplasenaTitle;
    private TextView[] textoDS1 = new TextView[15];
    private TextView[] textoDS2 = new TextView[15];
    private boolean gravado = false;
    int minAposta;
    int maxAposta;
    int qntInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duplasena);
        qntText = findViewById(R.id.qtdNumText);

        buttonduplasenaTitle = findViewById(R.id.duplasenaTitle);
        buttonduplasenaTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DuplasenaActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void duplasena(View view) {
        String qntString = qntText.getText().toString();

        qntInt = Integer.parseInt(qntString);
        minAposta = 6;
        maxAposta = 15;

        alert(minAposta, maxAposta, qntInt);

        if (!(qntInt < minAposta || qntInt > maxAposta)) {
            limpar(36);



            gravarExibirNumerosDuplaSena(qntInt);
        }
    }

    public void limparQnt(View view) {
        qntText.setText("");
    }

    public void gravarExibirNumerosDuplaSena(int dsSorteado) {
        geraNumeros(qntInt, 51);

        ordenar(qntInt);

        for (int i = 0; i < dsSorteado; i++) {
            textoDS1[i] = getTexto()[i];
        }

        textoDS1[0] = findViewById(R.id.txtResultado1);
        textoDS1[1] = findViewById(R.id.txtResultado2);
        textoDS1[2] = findViewById(R.id.txtResultado3);
        textoDS1[3] = findViewById(R.id.txtResultado4);
        textoDS1[4] = findViewById(R.id.txtResultado5);
        textoDS1[5] = findViewById(R.id.txtResultado6);
        textoDS1[6] = findViewById(R.id.txtResultado7);
        textoDS1[7] = findViewById(R.id.txtResultado8);
        textoDS1[8] = findViewById(R.id.txtResultado9);
        textoDS1[9] = findViewById(R.id.txtResultado10);
        textoDS1[10] = findViewById(R.id.txtResultado11);
        textoDS1[11] = findViewById(R.id.txtResultado12);
        textoDS1[12] = findViewById(R.id.txtResultado13);
        textoDS1[13] = findViewById(R.id.txtResultado14);
        textoDS1[14] = findViewById(R.id.txtResultado15);

        TextView txtOpcao = findViewById(R.id.txtOpcao);
        txtOpcao.setText("Números da Sorte 01!");

        for (int i = 0; i < dsSorteado; i++) {
            System.out.println(getVetLoteria()[i]);
            if (getVetLoteria()[i] < 10) {
                textoDS1[i].setText(" 0" + getVetLoteria()[i] + " ");
            } else {
                textoDS1[i].setText(" " + getVetLoteria()[i] + " ");
            }
        }

        geraNumeros(qntInt, 51);

        ordenar(qntInt);

        for (int i = 0; i < dsSorteado; i++) {
            textoDS2[i] = getTexto()[i];
        }

        textoDS2[0] = findViewById(R.id.txtResultado19);
        textoDS2[1] = findViewById(R.id.txtResultado20);
        textoDS2[2] = findViewById(R.id.txtResultado21);
        textoDS2[3] = findViewById(R.id.txtResultado22);
        textoDS2[4] = findViewById(R.id.txtResultado23);
        textoDS2[5] = findViewById(R.id.txtResultado24);
        textoDS2[6] = findViewById(R.id.txtResultado25);
        textoDS2[7] = findViewById(R.id.txtResultado26);
        textoDS2[8] = findViewById(R.id.txtResultado27);
        textoDS2[9] = findViewById(R.id.txtResultado28);
        textoDS2[10] = findViewById(R.id.txtResultado29);
        textoDS2[11] = findViewById(R.id.txtResultado30);
        textoDS2[12] = findViewById(R.id.txtResultado31);
        textoDS2[13] = findViewById(R.id.txtResultado32);
        textoDS2[14] = findViewById(R.id.txtResultado33);

        TextView txtOpcao2 = findViewById(R.id.txtOpcao2);
        txtOpcao2.setText("Números da Sorte 02!");

        for (int i = 0; i < dsSorteado; i++) {
            System.out.println(getVetLoteria()[i]);
            if (getVetLoteria()[i] < 10) {
                textoDS2[i].setText(" 0" + getVetLoteria()[i] + " ");
            } else {
                textoDS2[i].setText(" " + getVetLoteria()[i] + " ");
            }
        }

        gravado = true;
    }
}