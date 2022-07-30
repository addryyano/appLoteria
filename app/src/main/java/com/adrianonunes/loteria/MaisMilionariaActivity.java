    package com.adrianonunes.loteria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

    public class MaisMilionariaActivity extends MainActivity {

        private EditText qntText;
        private Button buttonMaisMilionariaTitle;
        private TextView[] textoDS1 = new TextView[15];
        private TextView[] textoDS2 = new TextView[15];
        private boolean gravado = false;
        int minAposta;
        int maxAposta;
        int qntInt;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_maismilionaria);
            qntText = findViewById(R.id.qtdNumText);

            buttonMaisMilionariaTitle = findViewById(R.id.MaisMilionariaTitle);
            buttonMaisMilionariaTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MaisMilionariaActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }

        public void maismilionaria(View view) {
            String qntString = qntText.getText().toString();

            Integer qntInt = Integer.parseInt(qntString);
            int minAposta = 6;
            int maxAposta = 12;

            alert(minAposta, maxAposta, qntInt);

            if (!(qntInt < minAposta || qntInt > maxAposta)) {
                limpar(18);

                geraNumeros(qntInt, 51);

                ordenar(qntInt);

                gravarExibirNumeros(qntInt);
            }
        }

        public void limparQnt(View view) {
            qntText.setText("");
        }
    }