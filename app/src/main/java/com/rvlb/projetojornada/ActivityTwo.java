package com.rvlb.projetojornada;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_two);

        String titulo = getIntent().getStringExtra("titulo");
        TextView tvA2 = (TextView) findViewById(R.id.tvA2);
        tvA2.setText(titulo);

        Button btA1 = (Button) findViewById(R.id.btA1);
        btA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityTwo.this, ActivityOne.class));
            }
        });
    }
}
