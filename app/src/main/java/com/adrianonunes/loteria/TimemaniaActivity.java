    package com.adrianonunes.loteria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

    public class TimemaniaActivity extends MainActivity {

    private EditText qntText;
    private Button buttonTimemaniaTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timemania);
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

        alert(minAposta, maxAposta, qntInt);

        if (!(qntInt < minAposta || qntInt > maxAposta)) {
            limpar(50);

            geraNumeros(qntInt, 81);

            ordenar(qntInt);

            gravarExibirNumeros(qntInt);
        }
    }

    public void limparQnt(View view) {
        qntText.setText("");
    }
}