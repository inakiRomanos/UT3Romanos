package com.politecnico.dam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class IncorrectoActivity extends AppCompatActivity {

    Button tryAgain, exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incorrecto);

        tryAgain = (Button)findViewById(R.id.tryagain);

        tryAgain.setOnClickListener(v -> {
            Intent i = new Intent(IncorrectoActivity.this, GameActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(i);
        });

        exit = (Button)findViewById(R.id.exit);

        exit.setOnClickListener(v -> {
            GameActivity.contador = GameActivity.contador +1;
            Intent i = new Intent(IncorrectoActivity.this, SplashscreenActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(i);
        });

    }
}

