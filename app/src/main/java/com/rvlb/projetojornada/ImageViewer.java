package com.rvlb.projetojornada;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ImageViewer extends Activity {

    private String nomesImagens[] = {"Imagem 1", "Imagem 2", "Imagem 3"};

    private EditText etNomeImagem;
    private TextView tvCurrentImg;
    private Spinner spImagens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);

        this.tvCurrentImg = (TextView) findViewById(R.id.tvCurrentImg);

        this.etNomeImagem = (EditText) findViewById(R.id.etNomeImagem);

        this.spImagens = (Spinner) findViewById(R.id.spImagens);
        this.spImagens.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, nomesImagens));
        this.spImagens.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvCurrentImg.setText(""+position);
                etNomeImagem.setText(spImagens.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
