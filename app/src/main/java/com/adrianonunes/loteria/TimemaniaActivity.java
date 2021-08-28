    package com.adrianonunes.loteria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

    public class TimemaniaActivity extends MainActivity {

        private TextView timeSorte;
        private EditText qntText;
        private Button buttonTimemaniaTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timemania);
        timeSorte = findViewById(R.id.timeSorte);
        qntText = findViewById(R.id.qtdNumText);

        buttonTimemaniaTitle = findViewById(R.id.timemaniaTitle);
        buttonTimemaniaTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TimemaniaActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void timemania(View view) {
        String qntString = qntText.getText().toString();

        Integer qntInt = Integer.parseInt(qntString);
        int minAposta = 10;
        int maxAposta = 10;
        boolean sorteiaTimeYoN;

        alert(minAposta, maxAposta, qntInt);

        if (!(qntInt < minAposta || qntInt > maxAposta)) {
            limpar(10);

            geraNumeros(qntInt, 81);

            ordenar(qntInt);

            gravarExibirNumeros(qntInt);

            sorteioTime(view);
        }
    }

    public void limparQnt(View view) {
        qntText.setText("");
    }

    public void sorteioTime(View view){
            String[] times = {
                    "Flamengo/RJ",
                    "Corinthians/SP",
                    "Santos/SP",
                    "Palmeiras/SP",
                    "São Paulo/SP",
                    "Grêmio/RS",
                    "Vasco da Gama/RJ",
                    "Internacional/RS",
                    "Botafogo/RJ",
                    "Atlético-MG/MG",
                    "Cruzeiro/MG",
                    "Fluminense/RJ",
                    "Bahia/BA",
                    "Fortaleza/CE",
                    "Goias/GO",
                    "Vitória/BA",
                    "Ceará/CE",
                    "ABC/RN",
                    "Avaí/SC",
                    "Atlético-PR/PR",
                    "Santa Cruz/PE",
                    "Treze/PB",
                    "Coritiba/PR",
                    "Atlético-GO/GO",
                    "Sport/PE",
                    "Londrina/PR",
                    "Guarani/SP",
                    "Remo/PA",
                    "Gama/DF",
                    "Náutico/PE",
                    "America-MG/MG",
                    "Joinville/SC",
                    "Juventude/RS",
                    "Ipatinga/MG",
                    "America/RJ",
                    "River/PI",
                    "Ituano/SP",
                    "América-RN/RN",
                    "Botafogo-PB/PB",
                    "Bangu/RJ",
                    "Portuguesa/SP",
                    "Moto Clube/MA",
                    "Vila Nova/GO",
                    "Mixto/MT",
                    "Ji-Paraná/RO",
                    "Marília/SP",
                    "Inter de Limeira/SP",
                    "Juventus/SP",
                    "Ponte Preta/SP",
                    "Paysandu/PA",
                    "Palmas/TO",
                    "Criciúma/SC",
                    "Sampaio Corrêa/MA",
                    "Paraná/PR",
                    "São Caetano/SP",
                    "Santo André/SP",
                    "Americano/RJ",
                    "CRB/AL",
                    "Bragantino/SP",
                    "Sergipe/SE",
                    "Barueri/SP",
                    "Figueirense/SC",
                    "Brasiliense/DF",
                    "Rio Branco-ES/ES",
                    "CSA/AL",
                    "Rio Branco-AC/AC",
                    "Tuna Luso/PA",
                    "Olaria/RJ",
                    "Ypiranga/AP",
                    "Uberlândia/MG",
                    "São Raimundo/AM",
                    "Nacional/AM",
                    "Operário/MS",
                    "Roraima/RR",
                    "União São João/SP",
                    "XV de Piracicaba/SP",
                    "Desportiva/ES",
                    "Paulista/SP",
                    "Villa Nova/MG",
                    "União Barbarense/SP"
            };

            int n1 = new Random().nextInt(80);

            TextView txtTime = findViewById(R.id.txtTime);
            txtTime.setText("  " + times[n1] + "  ");
            timeSorte.setText("Time da Sorte:");
        }
}