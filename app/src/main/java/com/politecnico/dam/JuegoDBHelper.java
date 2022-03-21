package com.politecnico.dam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class JuegoDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Juego.db";

    public JuegoDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    public void onCreate(SQLiteDatabase db) {
        db.execSQL(JuegoContract.SQL_CREATE_ENTRIES);

    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
