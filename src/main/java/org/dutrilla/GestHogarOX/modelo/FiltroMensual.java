package org.dutrilla.GestHogarOX.modelo;

import lombok.Getter;
import lombok.Setter;
import org.dutrilla.GestHogarOX.modelo.enums.Mes;
import org.openxava.annotations.View;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@View(members = "ejercicio; mes;")
@View(name = "filtro", members = "ejercicio; mes;")
@Getter @Setter
public class FiltroMensual {

    @Column(length = 4)
    private int ejercicio;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Mes mes;
}
