package org.dutrilla.GestHogarOX.filtros;

import org.openxava.filters.BaseContextFilter;
import org.openxava.filters.FilterException;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;

public class FiltroSistemaEjercicioMes extends BaseContextFilter {

    public Object filter(Object o) throws FilterException {

        Calendar calendario = Calendar.getInstance();

        int ejercicio = calendario.get(Calendar.YEAR);

        int numeroMes = calendario.get(Calendar.MONTH) + 1;

        String mes = obtenerNombreMes(numeroMes);

        return new Object[] { ejercicio, mes };
    }

    private String obtenerNombreMes(Integer numMes) {

        if (numMes == null || numMes < 1 || numMes > 12) return "MES DESCONOCIDO";

        return Month.of(numMes)
            .getDisplayName(TextStyle.FULL, new Locale("es", "ES"))
            .toUpperCase();
    }
}
