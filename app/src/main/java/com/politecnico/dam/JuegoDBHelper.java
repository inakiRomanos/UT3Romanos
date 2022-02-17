package com.politecnico.dam;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class JuegoDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Juego.db";

    public JuegoDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + JuegoContract.BaseDatosJuegosEntry.TABLE_NAME + " ("
                + JuegoContract.BaseDatosJuegosEntry.INDICE + " TEXT NOT NULL,"
                + JuegoContract.BaseDatosJuegosEntry.PREGUNTA + " TEXT NOT NULL,"
                + JuegoContract.BaseDatosJuegosEntry.FORMULA + " TEXT NOT NULL,"
                + JuegoContract.BaseDatosJuegosEntry.PRIMERA_RESPUESTA + " TEXT NOT NULL,"
                + JuegoContract.BaseDatosJuegosEntry.SEGUNDA_RESPUESTA + " TEXT NOT NULL)");

        ContentValues values = new ContentValues();

        values.put(JuegoContract.BaseDatosJuegosEntry.INDICE, "1/1");
        values.put(JuegoContract.BaseDatosJuegosEntry.PREGUNTA, "¿Cual es el resultado?");
        values.put(JuegoContract.BaseDatosJuegosEntry.FORMULA, "1+1=");
        values.put(JuegoContract.BaseDatosJuegosEntry.PRIMERA_RESPUESTA, "1");
        values.put(JuegoContract.BaseDatosJuegosEntry.SEGUNDA_RESPUESTA, "2");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
