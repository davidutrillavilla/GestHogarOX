package org.dutrilla.GestHogarOX.util;

import com.libreriaGeneral.util.GeneralUtil;
import org.dutrilla.GestHogarOX.modelo.Ciudad;
import org.dutrilla.GestHogarOX.modelo.dto.CiudadDto;
import java.sql.SQLException;

public enum CiudadUtil {

    INSTANCE;

    public Ciudad crearCiudad(CiudadDto ciudadDto){

        return GeneralUtil.INSTANCE.parseDtoEntity(ciudadDto, Ciudad.class);
    }
}
