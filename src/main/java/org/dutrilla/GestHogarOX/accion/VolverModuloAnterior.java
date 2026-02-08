package org.dutrilla.GestHogarOX.accion;

import org.openxava.actions.IChangeModuleAction;
import org.openxava.actions.ViewBaseAction;

public class VolverModuloAnterior extends ViewBaseAction implements IChangeModuleAction {

    String PREVIOUS_MODULE = "__PREVIOUS_MODULE__";

    public VolverModuloAnterior() {}

    public void execute() throws Exception{
    }

    public String getNextModule() {
        return PREVIOUS_MODULE;
    }

    public boolean hasReinitNextModule() {
        return false;
    }
}
