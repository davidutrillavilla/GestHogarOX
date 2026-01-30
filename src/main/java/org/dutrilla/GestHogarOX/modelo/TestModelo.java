package org.dutrilla.GestHogarOX.modelo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter @Setter
public class TestModelo {

    private String id;

    private Date fecha;

    private String texto;

    private int numero;

    private BigDecimal valor;
}
