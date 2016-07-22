package com.rvlb.projetojornada;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class FragmentActivity extends AppCompatActivity {

    private RelativeLayout tela1, tela2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        tela1 = (RelativeLayout) findViewById(R.id.rlTela1);
        tela2 = (RelativeLayout) findViewById(R.id.rlTela2);

        Button btTela1 = (Button) findViewById(R.id.button);
        btTela1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tela1.setVisibility(View.VISIBLE);
                tela2.setVisibility(View.GONE);
            }
        });

        Button btTela2 = (Button) findViewById(R.id.button2);
        btTela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tela1.setVisibility(View.GONE);
                tela2.setVisibility(View.VISIBLE);
            }
        });
    }
}
