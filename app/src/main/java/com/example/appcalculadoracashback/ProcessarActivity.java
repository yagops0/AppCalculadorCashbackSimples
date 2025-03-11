package com.example.appcalculadoracashback;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProcessarActivity extends AppCompatActivity implements View.OnClickListener {

    public double calcular(double valor){
        if (valor <= 100){
            valor = valor * 0.03;
            return valor;
        } else if (valor > 100 && valor <= 100) {
            valor = valor * 0.05;
            return valor;
        } else if (valor > 1000 && valor <= 6000) {
            valor = valor * 0.07;
            return valor;
        } else if (valor > 6000) {
            valor = valor * 0.1;
            return valor;
        }

        return 0.0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_processar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });





        Button btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(this);

        Button btnConcluir = findViewById(R.id.btnConcluir);
        btnConcluir.setOnClickListener(this);


    }
    EditText etValor = findViewById(R.id.etValor);
    double valor = Double.parseDouble(etValor.getText().toString());

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnConcluir){
            finish();
        } else if (v.getId() == R.id.btnCalcular) {
            if (valor <= 100.0){
                TextView textPercent = findViewById(R.id.tvPorcentagem);
                textPercent.setText("A porcentagem do cashback é 3%!!");

                TextView textValorCash = findViewById(R.id.tvValor);
                textValorCash.setText("O valor do seu cashback é R$ " + calcular(valor) + ".");
            } else if (valor > 100 && valor <= 1000) {
                TextView textPercent = findViewById(R.id.tvPorcentagem);
                textPercent.setText("A porcentagem do cashback é 5%!!");

                TextView textValorCash = findViewById(R.id.tvValor);
                textValorCash.setText("O valor do seu cashback é R$ " + calcular(valor) + ".");
            } else if (valor > 1000 && valor <= 6000) {
                TextView textPercent = findViewById(R.id.tvPorcentagem);
                textPercent.setText("A porcentagem do cashback é 7%!!");

                TextView textValorCash = findViewById(R.id.tvValor);
                textValorCash.setText("O valor do seu cashback é R$ " + calcular(valor) + ".");
            } else if (valor > 6000) {
                TextView textPercent = findViewById(R.id.tvPorcentagem);
                textPercent.setText("A porcentagem do cashback é 10%!!");

                TextView textValorCash = findViewById(R.id.tvValor);
                textValorCash.setText("O valor do seu cashback é R$ " + calcular(valor) + ".");
            }

        }
    }
}