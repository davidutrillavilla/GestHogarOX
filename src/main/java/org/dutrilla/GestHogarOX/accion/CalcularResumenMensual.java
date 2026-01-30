package org.dutrilla.GestHogarOX.accion;

import com.libreriaGeneral.OX.acccionOX.OXServiceAction;
import com.libreriaGeneral.util.ConstantesGenerales;

import org.dutrilla.GestHogarOX.modelo.dto.ResumenMensualTotalDto;
import org.dutrilla.GestHogarOX.service.GeneralService;

import javax.ws.rs.core.Response;
import java.sql.SQLException;

public class CalcularResumenMensual extends OXServiceAction<ResumenMensualTotalDto> {

    @Override
    protected ResumenMensualTotalDto setUp() {

        return ResumenMensualTotalDto.builder()
            .ejercicio(getView().getValueInt("ejercicio"))
            .mes(getView().getValueString("mesEnum"))
            .build();
    }

    @Override
    protected Response invokeService(ResumenMensualTotalDto resumenMensualTotalDto) throws SQLException, IllegalAccessException {

        return GeneralService.INSTANCE.calcularGastos(resumenMensualTotalDto);
    }

    @Override
    protected void handleResponse(Response response) {

        String info = "creacionErronea";

        if (response.getEntity() != null) { info = "creacionExitosa"; }

        addInfo(info, ConstantesGenerales.OBJETO_RESUMEN_MENSUAL);

    }

    public String getNextMode() {

        return LIST;
    }
}
