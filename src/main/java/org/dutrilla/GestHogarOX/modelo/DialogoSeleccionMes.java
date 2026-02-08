package org.dutrilla.GestHogarOX.modelo;

import lombok.Getter;
import lombok.Setter;
import org.dutrilla.GestHogarOX.modelo.enums.Ejercicio;
import org.dutrilla.GestHogarOX.modelo.enums.Mes;
import org.openxava.annotations.View;

@View(members = "ejercicio; mes")
@Getter @Setter
public class DialogoSeleccionMes {

    private Ejercicio ejercicio;

    private Mes mes;
}
