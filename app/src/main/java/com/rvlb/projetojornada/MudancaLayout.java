package com.rvlb.projetojornada;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MudancaLayout extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_mudanca_layout);
        carregaTelaPrincipal();
    }

    public void carregaTelaPrincipal() {
        setContentView(R.layout.activity_mudanca_layout);
        Button btTela2 = (Button) findViewById(R.id.btTela2);
        btTela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregaTela2();
            }
        });
        btTela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }

    public void carregaTela2() {
        setContentView(R.layout.tela2);
        Button btTela1 = (Button) findViewById(R.id.btTela1);
        btTela1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregaTelaPrincipal();
            }
        });
    }
}
