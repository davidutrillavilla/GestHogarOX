package org.dutrilla.GestHogarOX.accion;

import org.openxava.actions.TabBaseAction;

public class MostrarGastos extends TabBaseAction {

    @Override
    public void execute() throws Exception {
        System.out.println("Mostrar");

        Object ejercicioObj = getContext().get("GestHogarOX", "ejercicio_filtro", "ejercicio_filtro");
        Object mesObj = getContext().get("GestHogarOX", "mes_filtro", "mes_filtro");


        if (ejercicioObj != null && mesObj != null) {
            // 2. Castear/Convertir a los tipos exactos de la entidad
            // Si ejercicio es int en Gasto, pasamos un Integer
            Integer ejercicio = (Integer) ejercicioObj;

            // Si mes es un Enum en Gasto, pasamos el objeto Enum
            // OpenXava suele guardar el Enum directamente en el contexto
            // si se obtuvo de getView().getValue()
            Object mes = mesObj;

            // 3. Pasar el array de objetos con los tipos resueltos
            getTab().setConditionValue("ejercicio_filtro", ejercicio);

            getTab().setConditionValue("mes_filtro", mes);
        }
    }
}
