package org.dutrilla.GestHogarOX.accion;

import com.libreriaGeneral.accion.ChangeModuleActionWithFilter;
import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;
import java.util.Map;

@Getter @Setter
public class FiltrandoPorMes extends ChangeModuleActionWithFilter {

    private String siguienteModulo;

    public static final String BASE_CONDITION_EJERCICIO = "${ejercicio} = '%d'";

    public static final String BASE_CONDITION_MES = "${mes} = '%s'";

    @Override
    public void execute() throws Exception {

        super.execute();
    }

    @Override
    protected Map<String, String> getBaseConditions() {

        int ejercicio = getView().getValueInt("ejercicio");

        String mes = getView().getValueString("mes");

        System.out.println("getBaseConditions " + ejercicio + " " + mes);

        Map<String, String> conditions = new HashMap<>();

        conditions.put("ejercicio", String.format(BASE_CONDITION_EJERCICIO, ejercicio));

        conditions.put("mes", String.format(BASE_CONDITION_MES, mes));

        return conditions;
    }

    @Override
    public String getNextModule() {

        return siguienteModulo;
    }

    @Override
    public boolean hasReinitNextModule() {
        return false;
    }
}
