package org.dutrilla.GestHogarOX.accion;

import com.libreriaGeneral.OX.acccionOX.OXServiceAction;
import com.libreriaGeneral.util.GeneralUtil;
import org.dutrilla.GestHogarOX.modelo.dto.GastoDto;
import org.dutrilla.GestHogarOX.service.GeneralService;
import org.openxava.actions.IChangeModeAction;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

public class EliminarGasto extends OXServiceAction<GastoDto> implements IChangeModeAction {

    @Override
    protected GastoDto setUp() {

        return GeneralUtil.INSTANCE.parseViewAlDto(new GastoDto(), getView().getAllValues());
    }

    @Override
    protected Response invokeService(GastoDto gastoDto) throws SQLException {

        return GeneralService.INSTANCE.eliminarGasto(gastoDto);
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
