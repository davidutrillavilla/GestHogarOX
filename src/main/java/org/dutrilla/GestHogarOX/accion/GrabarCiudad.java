package org.dutrilla.GestHogarOX.accion;

import com.libreriaGeneral.OX.acccionOX.OXServiceAction;
import com.libreriaGeneral.util.ConstantesGenerales;

import com.libreriaGeneral.util.GeneralUtil;
import org.dutrilla.GestHogarOX.modelo.dto.CiudadDto;
import org.dutrilla.GestHogarOX.service.GeneralService;
import org.openxava.actions.IChangeModeAction;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

public class GrabarCiudad extends OXServiceAction<CiudadDto> implements IChangeModeAction {

    @Override
    protected CiudadDto setUp() {

        return GeneralUtil.INSTANCE.parseViewAlDto(new CiudadDto(), getView().getValues());
    }

    @Override
    protected Response invokeService(CiudadDto ciudadDto) throws SQLException, IllegalAccessException {

        return GeneralService.INSTANCE.grabarCiudad(ciudadDto);
    }

    @Override
    protected void handleResponse(Response response) {

        String info = "creacionErronea";

        if (response.getEntity() != null) { info = "creacionExitosa"; }

        addInfo(info, ConstantesGenerales.OBJETO_CIUDAD);

    }

    public String getNextMode() {

        return LIST;
    }
}
