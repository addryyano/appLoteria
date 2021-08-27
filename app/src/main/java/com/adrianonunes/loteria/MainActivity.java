package com.adrianonunes.loteria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnMegaSena;
    private Button btnLotomania;
    private Button btnLotofacil;
    private Button btnQuina;
    private Button btnDiadesorte;
    private Button btnTimemania;
    private Button btnDuplasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMegaSena = findViewById(R.id.btnMegaSena);
        btnLotomania = findViewById(R.id.btnLotomania);
        btnLotofacil = findViewById(R.id.btnLotofacil);
        btnQuina = findViewById(R.id.btnQuina);
        btnDiadesorte = findViewById(R.id.btnDiadesorte);
        btnTimemania = findViewById(R.id.btnTimeMania);
        btnDuplasena = findViewById(R.id.btnDuplaSena);

        btnMegaSena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MegaSenaActivity.class);
                startActivity(intent);
            }
        });

        btnLotomania.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LotomaniaActivity.class);
                startActivity(intent);
            }
        });

        btnLotofacil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LotofacilActivity.class);
                startActivity(intent);
            }
        });

        btnQuina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), QuinaActivity.class);
                startActivity(intent);
            }
        });

        btnDiadesorte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DiadesorteActivity.class);
                startActivity(intent);
            }
        });

        btnTimemania.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TimemaniaActivity.class);
                startActivity(intent);
            }
        });

        btnDuplasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DuplasenaActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean flag;
    private int[] vetLoteria = new int[50];
    private int sorteio;
    private TextView[] texto = new TextView[50];
    private boolean gravado = false;

    public void limpar(int nLimpar) {
        if (gravado) {
            for (int i = 0; i < nLimpar; i++) {
                System.out.println(vetLoteria[i]);
                texto[i].setText("");
                //texto[49].setText("");
            }
        }
    }

    public void geraNumeros(int nSorteado, int nTotal) {
        for (int i = 0; i < nSorteado; i++) {
            flag = true;
            while (flag == true) {
                sorteio = new Random().nextInt(nTotal);
                for (int n = 0; n < nSorteado; n++) {
                    if (sorteio == vetLoteria[n]) {
                        flag = true;
                        break;
                    } else {
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
        for (int a = 0; a < nSorteados; a++) {
            for (int b = a + 1; b < nSorteados; b++) {
                if (vetLoteria[a] > vetLoteria[b]) {
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
        txtOpcao.setText("Números da Sorte!");

        for (int i = 0; i < nSorteados2; i++) {
            System.out.println(vetLoteria[i]);
            if (vetLoteria[i] < 10) {
                texto[i].setText(" 0" + vetLoteria[i] + " ");
            } else if (vetLoteria[i] > 99) {
                texto[i].setText(" 00 ");
            } else {
                texto[i].setText(" " + vetLoteria[i] + " ");
            }
        }
        gravado = true;
    }


    public void alert(int minAposta, int maxAposta, int qntInt) {
        if (qntInt < minAposta || qntInt > maxAposta) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("ERRO!");
            alert.setMessage("Informe um valor entre " + minAposta + " e " + maxAposta);
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alert.create();
            alert.show();

        }
    }
}



