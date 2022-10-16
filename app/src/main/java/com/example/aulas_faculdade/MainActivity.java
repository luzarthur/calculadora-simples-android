package com.example.aulas_faculdade;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Spinner operacoes;
    int num1,num2,res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operacoes = (Spinner) findViewById(R.id.operacao);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.operacoes, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        operacoes.setAdapter(adapter);

        Button btn_op = (Button)findViewById(R.id.button);
        EditText et_valor1 = (EditText)findViewById(R.id.valor1);
        EditText et_valor2 = (EditText)findViewById(R.id.valor2);
        TextView resultado = (TextView)findViewById(R.id.result);

        btn_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String op_selected = operacoes.getSelectedItem().toString();
                num1 = Integer.parseInt(et_valor1.getText().toString());
                num2 = Integer.parseInt(et_valor2.getText().toString());

                if (op_selected.equals("Somar")) {
                    res = num1 + num2;
                } else if (op_selected.equals("Subtrair")) {
                    res = num1 - num2;
                } else if (op_selected.equals("Dividir")) {
                    res = num1 / num2;
                } else if (op_selected.equals("Multiplicar")) {
                    res = num1 * num2;
                }
                resultado.setText(String.valueOf(res));
            }
        });
    }
}
