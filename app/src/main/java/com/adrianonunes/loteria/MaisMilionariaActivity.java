    package com.adrianonunes.loteria;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.Random;

public class MaisMilionariaActivity extends MainActivity {

    private boolean flagT;
    private int[] vetTrevo = new int[6];
    private int sorteioT;
    private TextView[] textoTrevo = new TextView[6];
    private boolean gravadoTrevo = false;
    private EditText qntText, qntText2;
    private Button buttonmaismilionariaTitle;
    private TextView[] getTexto2() {
            return textoTrevo;
        }
    private int[] getVetTrevo() {return vetTrevo;}
    private int minApost = 6;
    private int maxApost = 12;
    private int minTrev = 2;
    private int maxTrev = 6;
    private Integer qntIn = 0;
    private Integer qntIn2 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maismilionaria);
        qntText = findViewById(R.id.qtdNumText);
        qntText2 = findViewById(R.id.qtdNumText2);

        buttonmaismilionariaTitle = findViewById(R.id.maismilionariaTitle);
        buttonmaismilionariaTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MaisMilionariaActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    public void maisMilionaria(View view) {
        String qntString = qntText.getText().toString();
        if (qntText.getText().toString().equals("")) {
            emBranco(view);
            return;
        }

        String qntString2 = qntText2.getText().toString();
        if (qntText2.getText().toString().equals("")) {
            emBranco(view);
            return;
        }

        qntIn = Integer.parseInt(qntString);
        qntIn2 = Integer.parseInt(qntString2);

        alert(minApost, maxApost, qntIn);

        alertT(minTrev, maxTrev, qntIn2);

        if (!(qntIn < minApost || qntIn > maxApost)) {
            limpar(12);

            geraNumeros(qntIn, 51);

            ordenar(qntIn);

            gravarExibirNumeros(qntIn);
        }

        if (!(qntIn2 < minTrev || qntIn2 > maxTrev)) {
            limparT(6);

            geraNumerosT(qntIn2, 7);

            ordenarT(qntIn2);

            gravarExibirTrevos(qntIn2);
        }

    }

    public void limparT(int tLimpar) {
        if (gravadoTrevo) {
            for (int i = 0; i < tLimpar; i++) {
                System.out.println(vetTrevo[i]);
                textoTrevo[i].setText("");
            }
        }
    }

    public void geraNumerosT(int nSorteadoT, int nTotalT) {
        for (int i = 0; i < nSorteadoT; i++) {
            flagT = true;
            while (flagT == true) {
                sorteioT = new Random().nextInt(nTotalT);
                for (int n = 0; n < nSorteadoT; n++) {
                    if (sorteioT == vetTrevo[n]) {
                        flagT = true;
                        break;
                    } else {
                        flagT = false;
                    }
                }
            }

            if (flagT == false && sorteioT != 0) {
                vetTrevo[i] = sorteioT;
            }
        }
    }

    public void ordenarT(int nSorteadosT) {
        for (int a = 0; a < nSorteadosT; a++) {
            for (int b = a + 1; b < nSorteadosT; b++) {
                if (vetTrevo[a] > vetTrevo[b]) {
                    int auxiliar = vetTrevo[a];
                    vetTrevo[a] = vetTrevo[b];
                    vetTrevo[b] = auxiliar;
                }
            }
        }
    }

    public void gravarExibirTrevos(int nSorteadosT) {
        textoTrevo[0] = findViewById(R.id.txtTrevo1);
        textoTrevo[1] = findViewById(R.id.txtTrevo2);
        textoTrevo[2] = findViewById(R.id.txtTrevo3);
        textoTrevo[3] = findViewById(R.id.txtTrevo4);
        textoTrevo[4] = findViewById(R.id.txtTrevo5);
        textoTrevo[5] = findViewById(R.id.txtTrevo6);

        TextView txtOpcao = findViewById(R.id.txtOpcao2);
        txtOpcao.setText("Trevos da Sorte!");

        for (int i = 0; i < nSorteadosT; i++) {
            System.out.println(vetTrevo[i]);
            textoTrevo[i].setText("  0" + vetTrevo[i] + "  ");
        }
        gravadoTrevo = true;
    }

    public void alertT(int minTrevo, int maxTrevo, int qntIntT) {
        if (qntIntT < minTrevo || qntIntT > maxTrevo) {
            AlertDialog.Builder alertT = new AlertDialog.Builder(this);
            alertT.setTitle("ERRO!");
            alertT.setMessage("Para trevos, informe um valor entre " + minTrevo + " e " + maxTrevo);
            alertT.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alertT.create();
            alertT.show();
        }
    }

    public void limparQnt(View view) {qntText.setText("");
    }

    public void limparQnt2(View view) {qntText.setText("");
    }
}