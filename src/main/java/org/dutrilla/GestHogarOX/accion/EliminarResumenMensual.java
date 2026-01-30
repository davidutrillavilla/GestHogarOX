package org.dutrilla.GestHogarOX.accion;

import com.libreriaGeneral.OX.acccionOX.OXServiceAction;
import org.dutrilla.GestHogarOX.modelo.dto.ResumenMensualTotalDto;
import org.dutrilla.GestHogarOX.service.GeneralService;
import org.openxava.actions.IChangeModeAction;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

public class EliminarResumenMensual extends OXServiceAction<ResumenMensualTotalDto> implements IChangeModeAction {

    @Override
    protected ResumenMensualTotalDto setUp() {

        return ResumenMensualTotalDto.builder()
            .id(getView().getValueString("id")).build();
    }

    @Override
    protected Response invokeService(ResumenMensualTotalDto resumenMensualTotalDto) throws SQLException, IllegalAccessException {

        return GeneralService.INSTANCE.eliminarResumenMensual(resumenMensualTotalDto);
    }

    @Override
    protected void handleResponse(Response response) {

        String info = "borradoFallido";

        if ((boolean) response.getEntity()) { info = "borradoExitoso"; }

        addInfo(info);
    }

    public String getNextMode() {

        return LIST;
    }
}
