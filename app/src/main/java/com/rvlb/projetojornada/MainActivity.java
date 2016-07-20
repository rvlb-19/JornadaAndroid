package com.rvlb.projetojornada;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etSalario, etPassword;
    private Button btCalcular, btConfirmar;
    private RadioGroup rgPercentuais;
    private RadioButton rb40;

    private AlertDialog.Builder alertDialog;

    private LinearLayout llOperacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.etPassword = (EditText) findViewById(R.id.etPassword);

        this.btConfirmar = (Button) findViewById(R.id.btConfirmar);
        this.btConfirmar.setOnClickListener(this);

        //

        this.llOperacao = (LinearLayout) findViewById(R.id.llOperacao);

        this.etSalario = (EditText) findViewById(R.id.etSalario);

        this.btCalcular = (Button) findViewById(R.id.btCalcular);
        this.btCalcular.setOnClickListener(this);

        this.rgPercentuais = (RadioGroup) findViewById(R.id.rgPercentuais);
        this.rb40 = (RadioButton) findViewById(R.id.rb40);

        this.alertDialog = new AlertDialog.Builder(this);
        this.alertDialog.setNeutralButton("Ok", null);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btConfirmar:
                if(etPassword.getText().toString().equals("senha"))  llOperacao.setVisibility(View.VISIBLE);
                else {
                    this.alertDialog.setTitle("Alerta");
                    alertDialog.setMessage("Senha incorreta");
                    alertDialog.show();
                }
                break;
            case R.id.btCalcular:
                Double salario = Double.parseDouble(etSalario.getText().toString());
                switch (this.rgPercentuais.getCheckedRadioButtonId()) {
                    case R.id.rb40:
                        salario *= 1.4;
                        break;
                    case R.id.rb45:
                        salario *= 1.45;
                        break;
                    case R.id.rb50:
                        salario *= 1.5;
                        break;
                }
                this.rb40.setChecked(true);
                this.etPassword.setText("");
                this.etSalario.setText("");
                alertDialog.setMessage("R$ "+salario);
                this.alertDialog.setTitle("Novo Salário");
                alertDialog.show();
                break;
        }
    }
}
