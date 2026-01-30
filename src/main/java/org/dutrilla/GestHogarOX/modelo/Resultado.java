package org.dutrilla.GestHogarOX.modelo;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter @Setter
public class Resultado {

    private int ejercicio;

    private String mes;

    private BigDecimal importeTotal;

    private BigDecimal importeTotalEnPescaderia;

    private BigDecimal importeTotalEnCarniceria;

    private BigDecimal importeTotalEnComprasGenericas;

    private BigDecimal importeTotalEnAlimentacion;

    private BigDecimal importeTotalEnRopa;

    private BigDecimal importeTotalEnCalzado;

    private BigDecimal importeTotalEnExtraescolares;

    private BigDecimal importeTotalEnFarmacia;

    private BigDecimal importeTotalEnOcio;

    private BigDecimal importeTotalEnHipoteca;

    private BigDecimal importeTotalEnLuz;

    private BigDecimal importeTotalEnComunidad;

    private BigDecimal importeTotalEnSeguros;

    private BigDecimal importesFijosCasa;

    private BigDecimal gastosMercadona;

    private BigDecimal gastosLidl;

    private BigDecimal gastosAldi;

    private BigDecimal gastosAlcampo;

    private BigDecimal gastosAlvimar;

    private BigDecimal gastosHnosSanchez;
}
