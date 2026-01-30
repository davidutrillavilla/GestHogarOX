package org.dutrilla.GestHogarOX.modelo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter
public class GastoDto {

    private String id;

    private String usuario;

    private LocalDate fecha;

    private int ejercicio;

    private String mesEnum;

    private String tipoComercioEnum;

    private String seccionGastoEnum;

    private String establecimiento;

    private String ciudad;

    private BigDecimal importeCompra;

    private String descripcion;

    @Override
    public String toString() {

        return id + " " + usuario + " " + fecha + " " + ejercicio + " " + mesEnum + " " + tipoComercioEnum + " " +
            seccionGastoEnum + " " + establecimiento + " " + ciudad + " " + importeCompra + " " + descripcion;
    }
}
