package org.dutrilla.GestHogarOX.accion;

import com.libreriaGeneral.OX.acccionOX.OXServiceAction;
import com.libreriaGeneral.util.GeneralUtil;
import org.dutrilla.GestHogarOX.modelo.dto.CiudadDto;
import org.dutrilla.GestHogarOX.service.GeneralService;
import org.openxava.actions.IChangeModeAction;

import javax.ws.rs.core.Response;
import java.sql.SQLException;

public class EliminarCiudad extends OXServiceAction<CiudadDto> implements IChangeModeAction {

    @Override
    protected CiudadDto setUp() {

        return GeneralUtil.INSTANCE.parseViewAlDto(new CiudadDto(), getView().getAllValues());
    }

    @Override
    protected Response invokeService(CiudadDto ciudadDto) throws SQLException {

        return GeneralService.INSTANCE.eliminarCiudad(ciudadDto);
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
