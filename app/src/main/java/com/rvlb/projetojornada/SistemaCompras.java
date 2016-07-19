package com.rvlb.projetojornada;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

public class SistemaCompras extends AppCompatActivity {

    private CheckBox cbArroz, cbLeite, cbCarne, cbFeijao;
    private AlertDialog.Builder resultDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_compras);

        this.cbArroz = (CheckBox) findViewById(R.id.cbArroz);
        this.cbLeite = (CheckBox) findViewById(R.id.cbLeite);
        this.cbCarne = (CheckBox) findViewById(R.id.cbCarne);
        this.cbFeijao = (CheckBox) findViewById(R.id.cbFeijao);

        this.resultDialog = new AlertDialog.Builder(this);
        this.resultDialog.setTitle("Aviso");
        this.resultDialog.setNeutralButton("Ok", null);
    }

    public void total(View v) {
        double sum = 0;
        if(cbArroz.isChecked()) sum += 2.69;
        if(cbLeite.isChecked()) sum += 5.00;
        if(cbCarne.isChecked()) sum += 9.70;
        if(cbFeijao.isChecked()) sum += 2.30;
        this.resultDialog.setMessage("Valor total: R$"+sum);
        this.resultDialog.show();
    }

}
