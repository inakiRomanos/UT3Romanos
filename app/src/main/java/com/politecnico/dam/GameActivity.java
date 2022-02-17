package com.politecnico.dam;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

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

        SQLiteDatabase db = con.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values1 = new ContentValues();
        values1.put(JuegoContract.BaseDatosJuegosEntry.INDICE, "1/1");
        values1.put(JuegoContract.BaseDatosJuegosEntry.PREGUNTA, "¿Cual es el resultado de la suma?");
        values1.put(JuegoContract.BaseDatosJuegosEntry.FORMULA, "1+1");
        values1.put(JuegoContract.BaseDatosJuegosEntry.PRIMERA_RESPUESTA, "2");
        values1.put(JuegoContract.BaseDatosJuegosEntry.SEGUNDA_RESPUESTA, "5");

// Insert the new row, returning the primary key value of the new row
        long newRowId1 = db.insert(JuegoContract.BaseDatosJuegosEntry.TABLE_NAME, null, values1);

        // Create a new map of values, where column names are the keys
        ContentValues values2 = new ContentValues();
        values2.put(JuegoContract.BaseDatosJuegosEntry.INDICE, "1/2");
        values2.put(JuegoContract.BaseDatosJuegosEntry.PREGUNTA, "¿Cual es el resultado de la resta?");
        values2.put(JuegoContract.BaseDatosJuegosEntry.FORMULA, "1-1");
        values2.put(JuegoContract.BaseDatosJuegosEntry.PRIMERA_RESPUESTA, "3");
        values2.put(JuegoContract.BaseDatosJuegosEntry.SEGUNDA_RESPUESTA, "0");

// Insert the new row, returning the primary key value of the new row
        long newRowId2 = db.insert(JuegoContract.BaseDatosJuegosEntry.TABLE_NAME, null, values2);

        // Create a new map of values, where column names are the keys
        ContentValues values3 = new ContentValues();
        values3.put(JuegoContract.BaseDatosJuegosEntry.INDICE, "1/1");
        values3.put(JuegoContract.BaseDatosJuegosEntry.PREGUNTA, "¿Cual es el resultado de la multiplicación?");
        values3.put(JuegoContract.BaseDatosJuegosEntry.FORMULA, "5x5");
        values3.put(JuegoContract.BaseDatosJuegosEntry.PRIMERA_RESPUESTA, "25");
        values3.put(JuegoContract.BaseDatosJuegosEntry.SEGUNDA_RESPUESTA, "52");

// Insert the new row, returning the primary key value of the new row
        long newRowId3 = db.insert(JuegoContract.BaseDatosJuegosEntry.TABLE_NAME, null, values3);

        // Create a new map of values, where column names are the keys
        ContentValues values4 = new ContentValues();
        values4.put(JuegoContract.BaseDatosJuegosEntry.INDICE, "1/1");
        values4.put(JuegoContract.BaseDatosJuegosEntry.PREGUNTA, "¿Cual es el resultado de la divisón?");
        values4.put(JuegoContract.BaseDatosJuegosEntry.FORMULA, "9/3");
        values4.put(JuegoContract.BaseDatosJuegosEntry.PRIMERA_RESPUESTA, "3");
        values4.put(JuegoContract.BaseDatosJuegosEntry.SEGUNDA_RESPUESTA, "33");

// Insert the new row, returning the primary key value of the new row
        long newRowId4 = db.insert(JuegoContract.BaseDatosJuegosEntry.TABLE_NAME, null, values4);

    }
}