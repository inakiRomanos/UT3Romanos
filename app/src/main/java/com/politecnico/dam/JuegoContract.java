package com.politecnico.dam;

import android.provider.BaseColumns;

/**
 * Esquema base de datos
 */

public class JuegoContract {

    public JuegoContract() {
    }

    public static  abstract class  BaseDatosJuegosEntry implements BaseColumns{

        public static final String TABLE_NAME ="juego";

        public static final String INDICE = "indice";
        public static final String PREGUNTA = "pregunta";
        public static final String FORMULA = "formula";
        public static final String PRIMERA_RESPUESTA = "primera_respuesta";
        public static final String SEGUNDA_RESPUESTA = "segunda_respuesta";
    }

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + BaseDatosJuegosEntry.TABLE_NAME + " (" +
                    BaseDatosJuegosEntry.INDICE + " TEXT," +
                    BaseDatosJuegosEntry.PREGUNTA + " TEXT," +
                    BaseDatosJuegosEntry.FORMULA + " TEXT," +
                    BaseDatosJuegosEntry.PRIMERA_RESPUESTA + " TEXT," +
                    BaseDatosJuegosEntry.SEGUNDA_RESPUESTA + " TEXT )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + BaseDatosJuegosEntry.TABLE_NAME;

}
