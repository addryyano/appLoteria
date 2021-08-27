    package com.adrianonunes.loteria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

    public class DuplasenaActivity extends MainActivity {

    private EditText qntText;
    private Button buttonduplasenaTitle;

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

        Integer qntInt = Integer.parseInt(qntString);
        int minAposta = 6;
        int maxAposta = 15;

        alert(minAposta, maxAposta, qntInt);

        if (!(qntInt < minAposta || qntInt > maxAposta)) {
            limpar(50);

            geraNumeros(qntInt, 51);

            ordenar(qntInt);

            gravarExibirNumeros(qntInt);
        }
    }

    public void limparQnt(View view) {
        qntText.setText("");
    }
}