package org.dutrilla.GestHogarOX.accion;

import com.libreriaGeneral.OX.acccionOX.OXServiceAction;
import com.libreriaGeneral.util.GeneralUtil;
import org.dutrilla.GestHogarOX.modelo.dto.EstablecimientoDto;
import org.dutrilla.GestHogarOX.service.GeneralService;
import org.openxava.actions.IChangeModeAction;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

public class EliminarEstablecimiento extends OXServiceAction<EstablecimientoDto> implements IChangeModeAction {

    @Override
    protected EstablecimientoDto setUp() {

        return GeneralUtil.INSTANCE.parseViewAlDto(new EstablecimientoDto(), getView().getAllValues());
    }

    @Override
    protected Response invokeService(EstablecimientoDto establecimientoDto) throws SQLException {

        return GeneralService.INSTANCE.eliminarEstablecimiento(establecimientoDto);
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
