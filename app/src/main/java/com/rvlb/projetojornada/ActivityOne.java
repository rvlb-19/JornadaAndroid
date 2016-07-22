package com.rvlb.projetojornada;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityOne extends Activity {

    private Button btA2;
    private EditText etTituloA2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_one);

        this.etTituloA2 = (EditText) findViewById(R.id.etTituloA2);
        this.btA2 = (Button) findViewById(R.id.btA2);
        this.btA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityTwo = new Intent(ActivityOne.this, ActivityTwo.class);
                activityTwo.putExtra("titulo", etTituloA2.getText().toString());
                startActivity(activityTwo);
            }
        });
    }
}
