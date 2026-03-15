package org.dutrilla.GestHogarOX.modelo.dto;

import com.libreriaGeneral.util.validador.RequiredField;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter
public class GastoDto {

    private String id;

    @RequiredField
    private String usuario;

    @RequiredField
    private LocalDate fecha;

    @RequiredField
    private int ejercicio;

    @RequiredField
    private String mesEnum;

    @RequiredField
    private String tipoComercioEnum;

    @RequiredField
    private String seccionGastoEnum;

    @RequiredField
    private String establecimiento;

    @RequiredField
    private String ciudad;

    @RequiredField
    private BigDecimal importeCompra;

    @RequiredField
    private String descripcion;

    @Override
    public String toString() {

        return id + " " + usuario + " " + fecha + " " + ejercicio + " " + mesEnum + " " + tipoComercioEnum + " " +
            seccionGastoEnum + " " + establecimiento + " " + ciudad + " " + importeCompra + " " + descripcion;
    }
}
