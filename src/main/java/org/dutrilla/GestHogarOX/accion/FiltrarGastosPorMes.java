package org.dutrilla.GestHogarOX.accion;

import com.libreriaGeneral.accion.ChangeModuleActionWithFilter;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class FiltrarGastosPorMes extends ChangeModuleActionWithFilter {

    private int ejercicio;

    private String mes;

    private String siguienteModulo;

    public static final String BASE_CONDITION_EJERCICIO = "${ejercicio} = '%d'";

    public static final String BASE_CONDITION_MES = "${mes} = '%s'";

    public static final String BASE_CONDITION = "${ejercicio} = '%d' AND ${mes} = '%s'";

    @Override
    protected StringBuffer getBaseCondition() {

        StringBuffer sb = super.getBaseCondition();

        System.out.println(ejercicio + " " + mes);

        addCondition(sb, String.format(BASE_CONDITION, ejercicio, mes));

        return sb;
    }

    @Override
    protected Map<String, String> getBaseConditions() {

        Map<String, String> baseConditions = new HashMap<>();

        baseConditions.put("ejercicio", BASE_CONDITION_EJERCICIO);

        baseConditions.put("mes", BASE_CONDITION_MES);

        return baseConditions;
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
