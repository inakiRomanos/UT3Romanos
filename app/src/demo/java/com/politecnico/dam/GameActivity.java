package com.politecnico.dam;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;


@SuppressWarnings("CanBeFinal")
public class GameActivity extends AppCompatActivity {

    TextView textoIndice, textoPregunta, textoFormula;
    RadioButton primeraOpcion, segundaOpcion;
    Button sendButton;
    public static int contador = 1;
    String contadorString = String.valueOf(contador);


    @SuppressWarnings("unused")
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
        values1.put(JuegoContract.BaseDatosJuegosEntry.ID, "1");
        values1.put(JuegoContract.BaseDatosJuegosEntry.INDICE, "1/4");
        values1.put(JuegoContract.BaseDatosJuegosEntry.PREGUNTA, getString(R.string.suma));
        values1.put(JuegoContract.BaseDatosJuegosEntry.FORMULA, "1+1");
        values1.put(JuegoContract.BaseDatosJuegosEntry.PRIMERA_RESPUESTA, "2");
        values1.put(JuegoContract.BaseDatosJuegosEntry.SEGUNDA_RESPUESTA, "5");
        values1.put(JuegoContract.BaseDatosJuegosEntry.RESPUESTA_CORRECTA, "2");


// Insert the new row, returning the primary key value of the new row
        long newRowId1 = db.insert(JuegoContract.BaseDatosJuegosEntry.TABLE_NAME, null, values1);

        // Create a new map of values, where column names are the keys
        ContentValues values2 = new ContentValues();
        values2.put(JuegoContract.BaseDatosJuegosEntry.ID, "2");
        values2.put(JuegoContract.BaseDatosJuegosEntry.INDICE, "2/4");
        values2.put(JuegoContract.BaseDatosJuegosEntry.PREGUNTA, getString(R.string.resta));
        values2.put(JuegoContract.BaseDatosJuegosEntry.FORMULA, "1-1");
        values2.put(JuegoContract.BaseDatosJuegosEntry.PRIMERA_RESPUESTA, "3");
        values2.put(JuegoContract.BaseDatosJuegosEntry.SEGUNDA_RESPUESTA, "0");
        values2.put(JuegoContract.BaseDatosJuegosEntry.RESPUESTA_CORRECTA, "0");


// Insert the new row, returning the primary key value of the new row
        long newRowId2 = db.insert(JuegoContract.BaseDatosJuegosEntry.TABLE_NAME, null, values2);

        // Create a new map of values, where column names are the keys
        ContentValues values3 = new ContentValues();
        values3.put(JuegoContract.BaseDatosJuegosEntry.ID, "3");
        values3.put(JuegoContract.BaseDatosJuegosEntry.INDICE, "3/4");
        values3.put(JuegoContract.BaseDatosJuegosEntry.PREGUNTA, getString(R.string.multiplicacion));
        values3.put(JuegoContract.BaseDatosJuegosEntry.FORMULA, "5x5");
        values3.put(JuegoContract.BaseDatosJuegosEntry.PRIMERA_RESPUESTA, "25");
        values3.put(JuegoContract.BaseDatosJuegosEntry.SEGUNDA_RESPUESTA, "52");
        values3.put(JuegoContract.BaseDatosJuegosEntry.RESPUESTA_CORRECTA, "25");


// Insert the new row, returning the primary key value of the new row
        long newRowId3 = db.insert(JuegoContract.BaseDatosJuegosEntry.TABLE_NAME, null, values3);

        // Create a new map of values, where column names are the keys
        ContentValues values4 = new ContentValues();
        values4.put(JuegoContract.BaseDatosJuegosEntry.ID, "4");
        values4.put(JuegoContract.BaseDatosJuegosEntry.INDICE, "4/4");
        values4.put(JuegoContract.BaseDatosJuegosEntry.PREGUNTA, getString(R.string.division));
        values4.put(JuegoContract.BaseDatosJuegosEntry.FORMULA, "9/3");
        values4.put(JuegoContract.BaseDatosJuegosEntry.PRIMERA_RESPUESTA, "33");
        values4.put(JuegoContract.BaseDatosJuegosEntry.SEGUNDA_RESPUESTA, "3");
        values4.put(JuegoContract.BaseDatosJuegosEntry.RESPUESTA_CORRECTA, "3");


// Insert the new row, returning the primary key value of the new row
        long newRowId4 = db.insert(JuegoContract.BaseDatosJuegosEntry.TABLE_NAME, null, values4);

        SQLiteDatabase db2 = con.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                JuegoContract.BaseDatosJuegosEntry.INDICE,
                JuegoContract.BaseDatosJuegosEntry.PREGUNTA,
                JuegoContract.BaseDatosJuegosEntry.FORMULA,
                JuegoContract.BaseDatosJuegosEntry.PRIMERA_RESPUESTA,
                JuegoContract.BaseDatosJuegosEntry.SEGUNDA_RESPUESTA,
                JuegoContract.BaseDatosJuegosEntry.RESPUESTA_CORRECTA,
        };

// Filter results WHERE "title" = 'My Title'
        String selection = JuegoContract.BaseDatosJuegosEntry.ID + " = ?";
        String[] selectionArgs = { contadorString };

// How you want the results sorted in the resulting Cursor

        @SuppressLint("Recycle") Cursor cursor = db2.query(
                JuegoContract.BaseDatosJuegosEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null              // The sort order
        );

        textoIndice= findViewById(R.id.TextoIndice);
        textoPregunta= findViewById(R.id.TextoPregunta);
        textoFormula= findViewById(R.id.TextoFormula);

        primeraOpcion= findViewById(R.id.PrimeraOpcion);
        segundaOpcion= findViewById(R.id.SegundaOpcion);

        cursor.moveToFirst();

        textoIndice.setText(cursor.getString(0));
        textoPregunta.setText(cursor.getString(1));
        textoFormula.setText(cursor.getString(2));

        primeraOpcion.setText(cursor.getString(3));
        String primeraRespuesta = cursor.getString(3);
        segundaOpcion.setText(cursor.getString(4));
        String segundaRespuesta = cursor.getString(4);
        String correctaRespuesta = cursor.getString(5);

        sendButton = findViewById(R.id.Send);

        sendButton.setOnClickListener(v -> {

            if(contador<1) {
                if (primeraOpcion.isChecked()) {
                    if (primeraRespuesta.equals(correctaRespuesta)) {
                        Intent i = new Intent(GameActivity.this, CorrectoActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(i);
                    } else {
                        Intent i = new Intent(GameActivity.this, IncorrectoActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(i);
                    }
                }
                if (segundaOpcion.isChecked()) {
                    if (segundaRespuesta.equals(correctaRespuesta)) {
                        Intent i = new Intent(GameActivity.this, CorrectoActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(i);
                    } else {
                        Intent i = new Intent(GameActivity.this, IncorrectoActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(i);
                    }
                }
            }
            else{

                if (primeraOpcion.isChecked()) {
                    if (primeraRespuesta.equals(correctaRespuesta)) {
                        Intent i = new Intent(GameActivity.this, FinalActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(i);
                    } else {
                        Intent i = new Intent(GameActivity.this, IncorrectoActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(i);
                    }
                }
                if (segundaOpcion.isChecked()) {
                    if (segundaRespuesta.equals(correctaRespuesta)) {
                        Intent i = new Intent(GameActivity.this, FinalActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(i);
                    } else {
                        Intent i = new Intent(GameActivity.this, IncorrectoActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(i);
                    }
                }

            }
            if(!(primeraOpcion.isChecked()) && !(segundaOpcion.isChecked())){
                Toast.makeText(this, R.string.seleccione_respuesta, Toast.LENGTH_LONG).show();
            }
        });

    }

}