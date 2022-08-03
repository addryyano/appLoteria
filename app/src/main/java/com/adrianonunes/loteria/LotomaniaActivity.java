    package com.adrianonunes.loteria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LotomaniaActivity extends MainActivity {

    private EditText qntText;
    private Button buttonlotomaniaTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lotomania);
        qntText = findViewById(R.id.qtdNumText);

        buttonlotomaniaTitle = findViewById(R.id.megaTitle);
        buttonlotomaniaTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LotomaniaActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    public void lotomania(View view) {
        String qntString = qntText.getText().toString();

        Integer qntInt = Integer.parseInt(qntString);
        int minAposta = 50;
        int maxAposta = 50;

        alert(minAposta, maxAposta, qntInt);

        if (!(qntInt < minAposta || qntInt > maxAposta)) {
            limpar(50);

            geraNumeros(qntInt, 101);

            ordenar(qntInt);

            gravarExibirNumeros(qntInt);
        }
    }

    public void limparQnt(View view) {
        qntText.setText("");
    }
}