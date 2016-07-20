package com.rvlb.projetojornada;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class SistemaCompras extends AppCompatActivity implements View.OnClickListener {

    private CheckBox cbArroz, cbLeite, cbCarne, cbFeijao;
    private TextView tvSubtotal;
    private Button btComprar;

    private int qnt[] = {0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_compras);

        this.cbArroz = (CheckBox) findViewById(R.id.cbArroz);
        this.cbLeite = (CheckBox) findViewById(R.id.cbLeite);
        this.cbCarne = (CheckBox) findViewById(R.id.cbCarne);
        this.cbFeijao = (CheckBox) findViewById(R.id.cbFeijao);

        this.cbArroz.setOnClickListener(this);
        this.cbLeite.setOnClickListener(this);
        this.cbCarne.setOnClickListener(this);
        this.cbFeijao.setOnClickListener(this);

        this.tvSubtotal = (TextView) findViewById(R.id.tvSubtotal);

        this.btComprar = (Button) findViewById(R.id.btComprar);
        this.btComprar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.cbArroz:
                qnt[0]++;
                cbArroz.setText("Arroz (R$ 2.69) - "+qnt[0]);
                break;
            case R.id.cbLeite:
                qnt[1]++;
                cbLeite.setText("Leite (R$ 5.00) - "+qnt[1]);
                break;
            case R.id.cbCarne:
                qnt[2]++;
                cbCarne.setText("Carne (R$ 9.70) - "+qnt[2]);
                break;
            case R.id.cbFeijao:
                qnt[3]++;
                cbFeijao.setText("Feijão (R$ 2.30) - "+qnt[3]);
                break;
            case R.id.btComprar:
                double total = (2.69*qnt[0]) + (5*qnt[1]) + (9.7*qnt[2]) + (2.3*qnt[3]);
                tvSubtotal.setText("Total: R$ " + total);
                qnt[0] = qnt[1] = qnt[2] = qnt[3] = 0;

                cbArroz.setChecked(false);
                cbArroz.setText("Arroz (R$ 2.69) - " + qnt[0]);

                cbLeite.setChecked(false);
                cbLeite.setText("Leite (R$ 5.00) - " + qnt[1]);

                cbCarne.setChecked(false);
                cbCarne.setText("Carne (R$ 9.70) - " + qnt[2]);

                cbFeijao.setChecked(false);
                cbFeijao.setText("Feijão (R$ 2.30) - "+qnt[3]);
                break;
        }
    }
}
