package org.dutrilla.GestHogarOX.accion;

import org.openxava.actions.NewAction;

public class NuevoGasto extends NewAction {

    private static final String VISTA_NUEVO = "nuevo";

    private String controlador;

    @Override
    public void execute() throws Exception {

        getView().setViewName(VISTA_NUEVO);

        super.execute();
    }
}
