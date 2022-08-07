    package com.adrianonunes.loteria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MegaSenaActivity extends MainActivity {

    private EditText qntText;
    private Button buttonmegaTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mega_sena);
        qntText = findViewById(R.id.qtdNumText);

        buttonmegaTitle = findViewById(R.id.megaTitle);
        buttonmegaTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MegaSenaActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    public void megaSena(View view) {
        String qntString = qntText.getText().toString();
        if (qntText.getText().toString().equals("")) {
            emBranco(view);
            return;
        }

        Integer qntInt = Integer.parseInt(qntString);
        int minAposta = 6;
        int maxAposta = 15;

        alert(minAposta, maxAposta, qntInt);

        if (!(qntInt < minAposta || qntInt > maxAposta)) {
            limpar(18);

            geraNumeros(qntInt, 61);

            ordenar(qntInt);

            gravarExibirNumeros(qntInt);
        }
    }

    public void limparQnt(View view) {
        qntText.setText("");
    }
}