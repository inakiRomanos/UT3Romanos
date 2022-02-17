package com.politecnico.dam;


import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;


public class GameActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ImageView randomImage = findViewById(R.id.random_image);
        Picasso.get().load("https://picsum.photos/200/300").into(randomImage); //Añade una imagen (aleatoria) de tamaño 200 x 300

        JuegoDBHelper con = new JuegoDBHelper(this);

    }
}