package com.politecnico.dam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

public class DashboardActivity extends AppCompatActivity {

    LinearLayout option_maps;
    LinearLayout option_contact;
    LinearLayout option_game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        option_maps = findViewById(R.id.layoutMaps);
        option_contact = findViewById(R.id.layoutContacts);
        option_game = findViewById(R.id.layoutGames);

        option_maps.setOnClickListener(v -> {
            Intent i = new Intent(DashboardActivity.this, MapsActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(i);
        });

        option_contact.setOnClickListener(v -> {
            Intent i = new Intent(DashboardActivity.this, ContactActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(i);
        });

        option_game.setOnClickListener(v -> {
            Intent i = new Intent(DashboardActivity.this, GameActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(i);
        });

    }
}