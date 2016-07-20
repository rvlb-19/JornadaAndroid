package com.rvlb.projetojornada;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Calculadora extends AppCompatActivity implements View.OnClickListener {

    private EditText etFirstNumber, etSecondNumber;
    private Button btSomar, btSubtrair, btMultiplicar, btDividir;
    private AlertDialog.Builder resultDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        this.etFirstNumber = (EditText) findViewById(R.id.etFirstNumber);
        this.etSecondNumber = (EditText) findViewById(R.id.etSecondNumber);

        this.btSomar = (Button) findViewById(R.id.btSomar);
        this.btSubtrair = (Button) findViewById(R.id.btSubtrair);
        this.btMultiplicar = (Button) findViewById(R.id.btMultiplicar);
        this.btDividir = (Button) findViewById(R.id.btDividir);

        this.btSomar.setOnClickListener(this);
        this.btSubtrair.setOnClickListener(this);
        this.btMultiplicar.setOnClickListener(this);
        this.btDividir.setOnClickListener(this);

        this.resultDialog = new AlertDialog.Builder(this);
        this.resultDialog.setNeutralButton("Ok", null);
    }

    @Override
    public void onClick(View v) {
        if(this.etFirstNumber.getText().toString().equals("") || this.etSecondNumber.getText().toString().equals("")) {
            this.resultDialog.setTitle("Erro");
            this.resultDialog.setMessage("Preencha os dois campos!!!");
        } else {
            double firstNumber = Double.parseDouble(this.etFirstNumber.getText().toString());
            double secondNumber = Double.parseDouble(this.etSecondNumber.getText().toString());
            double result = 0;
            switch (v.getId()) {
                case R.id.btSomar:
                    result = firstNumber + secondNumber;
                    this.resultDialog.setTitle("Soma");
                    break;
                case R.id.btSubtrair:
                    result = firstNumber - secondNumber;
                    this.resultDialog.setTitle("Subtração");
                    break;
                case R.id.btMultiplicar:
                    result = firstNumber * secondNumber;
                    this.resultDialog.setTitle("Multiplicação");
                    break;
                case R.id.btDividir:
                    result = firstNumber / secondNumber;
                    this.resultDialog.setTitle("Divisão");
                    break;
            }
            this.resultDialog.setMessage(""+result);
        }
        this.resultDialog.show();
    }
}