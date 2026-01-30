package org.dutrilla.GestHogarOX.util;

import com.libreriaGeneral.util.GeneralUtil;
import org.dutrilla.GestHogarOX.modelo.Establecimiento;
import org.dutrilla.GestHogarOX.modelo.dto.EstablecimientoDto;
import java.sql.SQLException;

public enum EstablecimientoUtil {

    INSTANCE;

    public Establecimiento crearEstablecimiento(EstablecimientoDto establecimientoDto) {

       return GeneralUtil.INSTANCE.parseDtoEntity(establecimientoDto, Establecimiento.class);
    }
}
