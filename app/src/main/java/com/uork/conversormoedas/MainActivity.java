package com.uork.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //implementação da interface View
    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mViewHolder.editValue = findViewById(R.id.edit_valor);
        this.mViewHolder.textDolar = findViewById(R.id.text_dolar);
        this.mViewHolder.textEuro = findViewById(R.id.text_euro);
        this.mViewHolder.buttonCalculate = findViewById(R.id.button_calculate);


        //chamando o método na própria Activity
        this.mViewHolder.buttonCalculate.setOnClickListener(this);
        this.clearValues();
    }

    private void clearValues() {
        this.mViewHolder.textEuro.setText(" ");
        this.mViewHolder.textDolar.setText(" ");
    }

    @Override
    public void onClick(View view) {
        //metodo de clique
        if (view.getId() == R.id.button_calculate) {
            String value = this.mViewHolder.editValue.getText().toString();
            if ("".equals(value)) {
                Toast.makeText(this, this.getString(R.string.informe_valor), Toast.LENGTH_SHORT).show();
            } else {
            Double real = Double.valueOf(value);
            this.mViewHolder.textDolar.setText(String.format("%.2f", (real / 4)));
            this.mViewHolder.textEuro.setText(String.format("%.2f", (real / 5)));
            }
        }
    }


    private static class ViewHolder {
        EditText editValue;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalculate;
    }



}
