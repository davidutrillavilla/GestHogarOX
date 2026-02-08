package org.dutrilla.GestHogarOX.modelo.enums;

import lombok.Getter;

@Getter
public enum Ejercicio {

    _2026("2026", 1),

    _2027("2026", 2),

    _2028("2026", 3),

    _2029("2026", 4),

    _2030("2026", 5),

    _2031("2026", 6),

    _2032("2026", 7),

    _2033("2026", 8),

    _2034("2026", 9),

    _2035("2026", 10),

    _2036("2026", 11),

    _2037("2026", 12),

    _2038("2026", 13),

    _2039("2026", 14),

    _2040("2026", 15);

    private String descripcion;

    private int codigoIdentificador;

    private Ejercicio(String descripcion, int codigoIdentificador){

        this.descripcion = descripcion;

        this.codigoIdentificador = codigoIdentificador;
    }

    public String getDescripcion() {

        return descripcion;
    }
}
