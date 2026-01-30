package org.dutrilla.GestHogarOX.accion;

import com.libreriaGeneral.OX.acccionOX.OXServiceAction;
import com.libreriaGeneral.util.GeneralUtil;
import org.dutrilla.GestHogarOX.modelo.dto.UsuarioDto;
import org.dutrilla.GestHogarOX.service.GeneralService;
import org.openxava.actions.IChangeModeAction;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

public class EliminarUsuario extends OXServiceAction<UsuarioDto> implements IChangeModeAction {

    @Override
    protected UsuarioDto setUp() {

       return GeneralUtil.INSTANCE.parseViewAlDto(new UsuarioDto(), getView().getAllValues());
    }

    @Override
    protected Response invokeService(UsuarioDto usuarioDto) throws SQLException, IllegalAccessException {

        return GeneralService.INSTANCE.eliminarUsuario(usuarioDto);
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
