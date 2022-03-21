package com.politecnico.dam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FinalActivity extends AppCompatActivity {

    Button restart, exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        restart = findViewById(R.id.restart);

        restart.setOnClickListener(v -> {
            GameActivity.contador = 1;
            Intent i = new Intent(FinalActivity.this, GameActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(i);
        });

        exit = findViewById(R.id.exit);

        exit.setOnClickListener(v -> {

            Intent i = new Intent(FinalActivity.this, DashboardActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(i);
        });

    }
}
