package org.dutrilla.GestHogarOX.modelo;

import groovy.util.logging.Slf4j;
import lombok.Getter;
import lombok.Setter;
import org.dutrilla.GestHogarOX.filtros.FiltroSistemaEjercicioMes;
import org.dutrilla.GestHogarOX.modelo.enums.Mes;
import org.dutrilla.GestHogarOX.modelo.enums.SeccionGasto;
import org.dutrilla.GestHogarOX.modelo.enums.TipoComercio;
import org.openxava.annotations.*;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Tab(name = "gasto", properties = "nombreUsuario, ejercicio, mes, fecha, seccionGasto, tipoComercio, nombreEstablecimiento, nombreCiudad, descripcion, importeCompra",
     filter = FiltroSistemaEjercicioMes.class,
     baseCondition = "${ejercicio} = ? and ${mes} = ?")
@View(members = "ejercicio, mesEnum, fecha;" +
                ";" +
                "usuario;" +
                ";" +
                "tipoComercioEnum, seccionGastoEnum, establecimiento, ciudad;" +
                "descripcion" +
                ";" +
                "importeCompra;"
)
@View(name = "generico", members = "ejercicio, mesEnum, fecha;" +
                                ";" +
                                "usuario;" +
                                ";" +
                                "tipoComercioEnum, seccionGastoEnum, establecimiento, ciudad;" +
                                "descripcion" +
                                ";" +
                                "importeCompra;"
)
@View(name = "nuevo", members = "ejercicio, mesEnum, fecha, usuario;" +
                                ";" +
                                "seccionGastoEnum, tipoComercioEnum;" +
                                ";" +
                                "establecimiento, ciudad;" +
                                "descripcion" +
                                ";" +
                                "importeCompra;"
)
@Entity
@Slf4j
@Getter
@Setter
@Table(schema = "dutrilla_gestion", name = "gasto")
@Access(AccessType.FIELD)
public class Gasto implements Serializable {

    @PrePersist
    private void setId(){

        this.setId(UUID.randomUUID().toString().replace("-", ""));

    }

    @Id
    @Hidden
    @Column(name = "id", length = 32, nullable = false, updatable = false, insertable = true)
    private String id;

    @Column(name = "ejercicio", length = 4)
    private int ejercicio;

    @Enumerated(EnumType.STRING)
    private Mes mesEnum;

    @Column(name = "mes", length = 10)
    private String mes;

    @Column(name = "fecha", length = 8)
    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    private TipoComercio tipoComercioEnum;

    @Column(name = "tipocomercio", length = 10)
    private String tipoComercio;

    @Enumerated(EnumType.STRING)
    private SeccionGasto seccionGastoEnum;

    @Column(name = "secciongasto", length = 30)
    private String seccionGasto;

    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList(descriptionProperties = "nombreEstablecimiento")
    @JoinColumn(name = "establecimiento", referencedColumnName = "id")
    @NoModify @NoCreate @NoFrame
    private Establecimiento establecimiento;

    @Column(name = "nombreEstablecimiento", length = 30)
    private String nombreEstablecimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList(descriptionProperties = "nombreCompleto")
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @NoModify @NoCreate @NoFrame
    private Usuario usuario;

    @Column(name = "nombreUsuario", length = 50)
    private String nombreUsuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList(descriptionProperties = "ciudad")
    @JoinColumn(name = "ciudad", referencedColumnName = "id")
    @NoModify @NoCreate @NoFrame
    private Ciudad ciudad;

    @Column(name = "nombreCiudad", length = 30)
    private String nombreCiudad;

    @Column(name = "importeCompra", length = 10, scale = 2)
    private BigDecimal importeCompra;

    @Column(name = "descripcion", length = 200)
    private String descripcion;

}
