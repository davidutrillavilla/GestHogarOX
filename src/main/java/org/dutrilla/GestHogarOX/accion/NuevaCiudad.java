package org.dutrilla.GestHogarOX.accion;

import lombok.Getter;
import lombok.Setter;
import org.openxava.actions.NewAction;

@Getter @Setter
public class NuevaCiudad extends NewAction {

    private static final String VISTA_NUEVO = "nuevo";

    private String controlador;

    @Override
    public void execute() throws Exception {

        getView().setViewName(VISTA_NUEVO);

        super.execute();

    }
}
