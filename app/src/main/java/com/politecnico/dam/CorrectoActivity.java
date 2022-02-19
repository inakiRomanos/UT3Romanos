package com.politecnico.dam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CorrectoActivity extends AppCompatActivity {

    Button next, exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correcto);

        next = (Button)findViewById(R.id.next);

        next.setOnClickListener(v -> {
            GameActivity.contador = GameActivity.contador +1;
            Intent i = new Intent(CorrectoActivity.this, GameActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(i);
        });

        exit = (Button)findViewById(R.id.exit);

        exit.setOnClickListener(v -> {
            Intent i = new Intent(CorrectoActivity.this, SplashscreenActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(i);
        });

    }
}