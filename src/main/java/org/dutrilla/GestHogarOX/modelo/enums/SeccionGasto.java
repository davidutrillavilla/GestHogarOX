package org.dutrilla.GestHogarOX.modelo.enums;

import lombok.Getter;

@Getter
public enum SeccionGasto {

    ALIMENTACION("AL", 1),

    ROPA("RO", 2),

    CALZADO("CA", 3),

    DEPORTE("DE", 4),

    EXTRAESCOLARES("EX", 5),

    OCIO("OC", 6),

    HIPOTECA("HI", 7),

    LUZ("LU", 8),

    COMUNIDAD("CO", 9),

    SEGUROS("SE", 10),

    FARMACIA("FA", 11),

    OPTICA("OP", 12);

    private String codigo;

    private int codigoIdentificador;

    private SeccionGasto(String codigo, int codigoIdentificador){

        this.codigo = codigo;

        this.codigoIdentificador = codigoIdentificador;
    }

    public String getCodigo() {

        return codigo;
    }
}
