package org.dutrilla.GestHogarOX.accion;

import org.openxava.actions.BaseAction;

public class SetFechaActual extends BaseAction {

    public void execute() throws Exception {

        int ejercicio = java.time.LocalDate.now().getYear();

        int mes = java.time.LocalDate.now().getMonthValue();

        getContext().put(getManager().getApplicationName(), null, "ejercicioActual", ejercicio);

        getContext().put(getManager().getApplicationName(), null, "mesActual", mes);

    }
}
