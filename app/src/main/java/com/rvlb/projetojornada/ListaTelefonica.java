package com.rvlb.projetojornada;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListaTelefonica extends Activity {

    private ListView lvContatos;
    private String contatos[] = {"Fulano", "Beltrano", "Cicrano"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_telefonica);

        this.lvContatos = (ListView) findViewById(R.id.lvContatos);
        this.lvContatos.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,contatos));
        this.lvContatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(ListaTelefonica.this);
                dialog.setTitle("Contato selecionado");
                dialog.setMessage(((TextView) view).getText().toString());
                dialog.setNeutralButton("Ok", null);
                dialog.show();
            }
        });
    }
}
