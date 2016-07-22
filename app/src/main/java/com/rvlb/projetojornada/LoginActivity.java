package com.rvlb.projetojornada;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class LoginActivity extends AppCompatActivity {

    private EditText etNome;
    private Spinner spFuncao;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.etNome = (EditText) findViewById(R.id.etNome);

        String funcoes[] = {"Escolha uma função", "Gestor", "Vendedor"};
        this.spFuncao = (Spinner) findViewById(R.id.spFuncao);
        this.spFuncao.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, funcoes));

        this.btLogin = (Button) findViewById(R.id.btLogin);
        this.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = etNome.getText().toString();
                int op = spFuncao.getSelectedItemPosition();
                if(nome.equals("")) {

                } else if(op == 0) {

                } else {
                    Intent intent;
                    if(op == 1) intent = new Intent(LoginActivity.this, SalarioSpinner.class);
                    else intent = new Intent(LoginActivity.this, SistemaCompras.class);
                    intent.putExtra("nome", nome);
                    startActivity(intent);
                }
            }
        });
    }
}
