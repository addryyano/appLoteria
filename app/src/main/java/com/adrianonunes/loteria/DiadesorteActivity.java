    package com.adrianonunes.loteria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DiadesorteActivity extends MainActivity {

    private EditText qntText;
    private Button buttondiadesorteTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diadesorte);
        qntText = findViewById(R.id.qtdNumText);

        buttondiadesorteTitle = findViewById(R.id.diadesorteTitle);
        buttondiadesorteTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DiadesorteActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void diadeSorte(View view) {
        String qntString = qntText.getText().toString();

        Integer qntInt = Integer.parseInt(qntString);
        int minAposta = 7;
        int maxAposta = 15;

        alert(minAposta, maxAposta, qntInt);

        if (!(qntInt < minAposta || qntInt > maxAposta)) {
            limpar(50);

            geraNumeros(qntInt, 32);

            ordenar(qntInt);

            gravarExibirNumeros(qntInt);
        }
    }

    public void limparQnt(View view) {
        qntText.setText("");
    }
}