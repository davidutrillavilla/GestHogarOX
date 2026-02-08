package org.dutrilla.GestHogarOX.accion;

import org.openxava.actions.ViewBaseAction;
import org.openxava.util.Dates;

public class AlIniciarFiltroMensual extends ViewBaseAction {

    @Override
    public void execute() throws Exception {

        getView().setValue("ejercicio", Dates.getYear(Dates.createCurrent()));
    }
}
