package org.dutrilla.GestHogarOX.modelo;

import lombok.Getter;
import lombok.Setter;
import org.dutrilla.GestHogarOX.modelo.enums.Mes;
import org.openxava.annotations.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Tab(name = "resumenMensualTotal", properties = "fechaCalculo, ejercicio, mes, importeTotal")
@View(name = "introducirDatos", members = "ejercicio, mesEnum")
@View(name = "resumenMensualTotal", members = "fechaCalculo, ejercicio, mes;" +
                                              "gastosPorTipoDeComercio [" +
                                              "     importeTotalEnCarniceria, importeTotalEnPescaderia, importeTotalEnComprasGenericas;" +
                                              "     importeTotalEnAlimentacion;" +
                                              "];" +
                                              "gastosPorTipoDeProducto [" +
                                              "     importeTotalEnRopa, importeTotalEnCalzado, importeTotalEnFarmacia;" +
                                              "];" +
                                              "gastosExtras [" +
                                              "     importeTotalEnExtraescolares, importeTotalEnOcio;" +
                                              "];" +
                                              "gastosDelInmueble [" +
                                              "     importeHipoteca, importeLuz, importeSeguros;" +
                                              "     importesFijosCasa;" +
                                              "];" +
                                              "gastosEnSupermercados [" +
                                              "     gastoMercadona, gastoAldi, gastoLidl, gastoAlcampo, gastoAlvimar, gastoHnosSanchez;" +
                                              "];" +
                                              "gastoTotal [" +
                                              "     importeTotal;" +
                                              "];"
)
@Table(schema = "dutrilla_gestion", name = "resumenmensualtotal")
@Access(AccessType.FIELD)
@Entity
@Getter @Setter
public class ResumenMensualTotal implements Serializable {

    @PrePersist
    private void setId(){

        setId(UUID.randomUUID().toString().replace("-", ""));
    }

    @Id
    @Hidden
    @Required
    @Column(name = "id", length = 32, nullable = false)
    private String id;

    @LabelFormat(value = LabelFormatType.SMALL)
    @Column(name = "ejercicio", length = 4)
    private int ejercicio;

    @Enumerated(EnumType.STRING)
    private Mes mesEnum;

    @Column(name = "mes", length = 10)
    private String mes;

    @Column(name = "fechacalculo", length = 8)
    private LocalDate fechaCalculo;

    @Column(name = "importeTotal", length = 10, scale = 2)
    @LabelFormat(value = LabelFormatType.NORMAL)
    private BigDecimal importeTotal;

    @LabelFormat(value = LabelFormatType.NORMAL)
    @Column(name = "importeTotalEnPescaderia", length = 10, scale = 2)
    private BigDecimal importeTotalEnPescaderia;

    @LabelFormat(value = LabelFormatType.NORMAL)
    @Column(name = "importeTotalEnCarniceria", length = 10, scale = 2)
    private BigDecimal importeTotalEnCarniceria;

    @LabelFormat(value = LabelFormatType.NORMAL)
    @Column(name = "importeTotalEnComprasGenericas", length = 10, scale = 2)
    private BigDecimal importeTotalEnComprasGenericas;

    @LabelFormat(value = LabelFormatType.NORMAL)
    @Column(name = "importeTotalEnAlimentacion", length = 10, scale = 2)
    private BigDecimal importeTotalEnAlimentacion;

    @LabelFormat(value = LabelFormatType.NORMAL)
    @Column(name = "importeTotalEnRopa", length = 10, scale = 2)
    private BigDecimal importeTotalEnRopa;

    @LabelFormat(value = LabelFormatType.NORMAL)
    @Column(name = "importeTotalEnCalzado", length = 10, scale = 2)
    private BigDecimal importeTotalEnCalzado;

    @LabelFormat(value = LabelFormatType.NORMAL)
    @Column(name = "importeTotalEnExtraescolares", length = 10, scale = 2)
    private BigDecimal importeTotalEnExtraescolares;

    @LabelFormat(value = LabelFormatType.NORMAL)
    @Column(name = "importeTotalEnFarmacia", length = 10, scale = 2)
    private BigDecimal importeTotalEnFarmacia;

    @LabelFormat(value = LabelFormatType.NORMAL)
    @Column(name = "importeTotalEnOcio", length = 10, scale = 2)
    private BigDecimal importeTotalEnOcio;

    @LabelFormat(value = LabelFormatType.NORMAL)
    @Column(name = "importeHipoteca", length = 10, scale = 2)
    private BigDecimal importeHipoteca;

    @LabelFormat(value = LabelFormatType.NORMAL)
    @Column(name = "importeLuz", length = 10, scale = 2)
    private BigDecimal importeLuz;

    @LabelFormat(value = LabelFormatType.NORMAL)
    @Column(name = "importeSeguros", length = 10, scale = 2)
    private BigDecimal importeSeguros;

    @LabelFormat(value = LabelFormatType.NORMAL)
    @Column(name = "importeComunidad", length = 10, scale = 2)
    private BigDecimal importeComunidad;

    @LabelFormat(value = LabelFormatType.NORMAL)
    @Column(name = "importesFijosCasa", length = 10, scale = 2)
    private BigDecimal importesFijosCasa;

    @LabelFormat(value = LabelFormatType.NORMAL)
    @Column(name = "gastoMercadona", length = 10, scale = 2)
    private BigDecimal gastoMercadona;

    @LabelFormat(value = LabelFormatType.NORMAL)
    @Column(name = "gastoAldi", length = 10, scale = 2)
    private BigDecimal gastoAldi;

    @LabelFormat(value = LabelFormatType.NORMAL)
    @Column(name = "gastoLidl", length = 10, scale = 2)
    private BigDecimal gastoLidl;

    @LabelFormat(value = LabelFormatType.NORMAL)
    @Column(name = "gastoAlcampo", length = 10, scale = 2)
    private BigDecimal gastoAlcampo;

    @LabelFormat(value = LabelFormatType.NORMAL)
    @Column(name = "gastoAlvimar", length = 10, scale = 2)
    private BigDecimal gastoAlvimar;

    @LabelFormat(value = LabelFormatType.NORMAL)
    @Column(name = "gastoHnosSanchez", length = 10, scale = 2)
    private BigDecimal gastoHnosSanchez;
}
