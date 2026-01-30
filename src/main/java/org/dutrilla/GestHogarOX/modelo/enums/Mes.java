package org.dutrilla.GestHogarOX.modelo.enums;

import lombok.Getter;

@Getter
public enum Mes {

    ENERO("EN", 1),

    FEBRERO("FE", 2),

    MARZO("MA", 3),

    ABRIL("AB", 4),

    MAYO("MY", 5),

    JUNIO("JU", 6),

    JULIO("JL", 7),

    AGOSTO("AG", 8),

    SEPTIEMBRE("SE", 9),

    OCTUBRE("OC", 10),

    NOVIEMBRE("NO", 11),

    DICIEMBRE("DI", 12);

    private String descripcion;

    private int codigoIdentificador;

    private Mes(String descripcion, int codigoIdentificador){

        this.descripcion = descripcion;

        this.codigoIdentificador = codigoIdentificador;
    }

    public String getDescripcion() {

        return descripcion;
    }
}
