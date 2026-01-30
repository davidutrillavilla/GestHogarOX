package org.dutrilla.GestHogarOX.modelo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;

@Getter @Setter
public class TestDto {

    private String id;

    private Date fecha;

    private int numero;

    private String texto;

    private BigDecimal valor;
}
