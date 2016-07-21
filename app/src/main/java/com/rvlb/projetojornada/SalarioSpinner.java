package com.rvlb.projetojornada;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class SalarioSpinner extends Activity {

    private String percentuais[] = {"Selecione um percentual", "", "", ""};
    private String cargos[] = {"Selecione um cargo", "Funcionário", "Gerente", "Diretor"};

    private int percentual = 0;

    private ArrayAdapter<String> adapterPercentuais, adapterCargos;
    private Spinner spCargos, spPercentuais;

    private Button btCalcular;
    private EditText etSalario;

    private AlertDialog.Builder alertDialog;

    private LinearLayout llPercentuais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salario_spinner);

        llPercentuais = (LinearLayout) findViewById(R.id.llPercentuais);

        adapterCargos = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cargos);
        spCargos = (Spinner) findViewById(R.id.spCargos);
        spCargos.setAdapter(adapterCargos);
        spCargos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                llPercentuais.setVisibility(View.VISIBLE);
                switch (position) {
                    case 0:
                        llPercentuais.setVisibility(View.GONE);
                        break;
                    case 1:
                        percentuais[1] = "10%";
                        percentuais[2] = "15%";
                        percentuais[3] = "20%";
                        break;
                    case 2:
                        percentuais[1] = "20%";
                        percentuais[2] = "25%";
                        percentuais[3] = "30%";
                        break;
                    case 3:
                        percentuais[1] = "30%";
                        percentuais[2] = "35%";
                        percentuais[3] = "40%";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        alertDialog = new AlertDialog.Builder(this);
        alertDialog.setNeutralButton("Ok", null);

        etSalario = (EditText) findViewById(R.id.etSalario);

        adapterPercentuais = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, percentuais);
        spPercentuais = (Spinner) findViewById(R.id.spPercentuais);
        spPercentuais.setAdapter(adapterPercentuais);
        spPercentuais.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        percentual = 0;
                        break;
                    default:
                        percentual = Integer.parseInt(percentuais[position].substring(0,2));
                        Log.d("percentual", ""+percentual);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btCalcular = (Button) findViewById(R.id.btCalcular);
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double salario = Double.parseDouble(etSalario.getText().toString());
                alertDialog.setTitle("Novo Salário");
                int op = spPercentuais.getSelectedItemPosition();
                alertDialog.setMessage("Escolha uma opção válida!");
                if (op != 0) {
                    double p = percentual/100.0;
                    salario *= (1+p);
                    alertDialog.setMessage("R$" + salario);
                }
                alertDialog.show();
            }
        });
    }
}
