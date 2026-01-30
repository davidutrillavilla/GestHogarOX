package org.dutrilla.GestHogarOX.accion;

import org.openxava.actions.NewAction;

public class IntroducirDatosCalculo extends NewAction {

    private static final String VISTA_GET_DATOS = "introducirDatos";

    private String controlador;

    @Override
    public void execute() throws Exception {

        getView().setViewName(VISTA_GET_DATOS);

        super.execute();

    }
}
