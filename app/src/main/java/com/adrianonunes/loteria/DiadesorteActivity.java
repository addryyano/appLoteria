    package com.adrianonunes.loteria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

    public class DiadesorteActivity extends MainActivity {
        private TextView mesSorte;
        private EditText qntText;
        private Button buttondiadesorteTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diadesorte);
        qntText = findViewById(R.id.qtdNumText);
        mesSorte = findViewById(R.id.mesSorte);

        buttondiadesorteTitle = findViewById(R.id.diadesorteTitle);
        buttondiadesorteTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DiadesorteActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    public void diadeSorte(View view) {
        String qntString = qntText.getText().toString();
        if (qntText.getText().toString().equals("")) {
            emBranco(view);
            return;
        }

        Integer qntInt = Integer.parseInt(qntString);
        int minAposta = 7;
        int maxAposta = 15;

        alert(minAposta, maxAposta, qntInt);

        if (!(qntInt < minAposta || qntInt > maxAposta)) {
            limpar(18);

            geraNumeros(qntInt, 32);

            ordenar(qntInt);

            gravarExibirNumeros(qntInt);

            sorteioMes(view);
        }
    }

    public void limparQnt(View view) {
        qntText.setText("");
    }

    public void sorteioMes(View view){
        String[] meses = {
                "Janeiro",
                "Fevereiro",
                "Março",
                "Abril",
                "Maio",
                "Junho",
                "Julho",
                "Agosto",
                "Setembro",
                "Outubro",
                "Novembro",
                "Dezembro"
        };

        int n1 = new Random().nextInt(12);

        TextView txtMes = findViewById(R.id.txtMes);
        txtMes.setText("   " + meses[n1] + "   ");
        mesSorte.setText("Mês da Sorte:");
    }
}