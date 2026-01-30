package org.dutrilla.GestHogarOX.accion;

import com.libreriaGeneral.OX.acccionOX.OXServiceAction;
import com.libreriaGeneral.util.ConstantesGenerales;

import com.libreriaGeneral.util.GeneralUtil;
import org.dutrilla.GestHogarOX.modelo.dto.EstablecimientoDto;
import org.dutrilla.GestHogarOX.service.GeneralService;

import javax.ws.rs.core.Response;
import java.sql.SQLException;

public class GrabarEstablecimiento extends OXServiceAction<EstablecimientoDto> {

    @Override
    protected EstablecimientoDto setUp() {

        return GeneralUtil.INSTANCE.parseViewAlDto(new EstablecimientoDto(), getView().getAllValues());
    }

    @Override
    protected Response invokeService(EstablecimientoDto establecimientoDto) throws SQLException, IllegalAccessException {

        return GeneralService.INSTANCE.grabarEstablecimiento(establecimientoDto);
    }

    @Override
    protected void handleResponse(Response response) {

        String info = "creacionErronea";

        if (response.getEntity() != null) { info = "creacionExitosa"; }

        addInfo(info, ConstantesGenerales.OBJETO_ESTABLECIMIENTO);

    }

    public String getNextMode() {

        return LIST;
    }
}
