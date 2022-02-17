package com.politecnico.dam;

/**
 * Entidad Base de Datos Juegos
 */

public class Juego {
    private String id;
    private String indice;
    private String pregunta;
    private String formula;
    private String primeraRespuesta;
    private String segundaRespuesta;

    public Juego(String id, String indice, String pregunta, String formula, String primeraRespuesta, String segundaRespuesta) {
        this.id = id;
        this.indice = indice;
        this.pregunta = pregunta;
        this.formula = formula;
        this.primeraRespuesta = primeraRespuesta;
        this.segundaRespuesta = segundaRespuesta;
    }

    public String getString() {

        return id;
    }

    public String getIndice() {

        return indice;
    }

    public String getPregunta() {

        return pregunta;
    }

    public String getFormula() {

        return formula;
    }

    public String getPrimeraRespuesta() {

        return primeraRespuesta;
    }

    public String getSegundaRespuesta() {

        return segundaRespuesta;
    }
}
