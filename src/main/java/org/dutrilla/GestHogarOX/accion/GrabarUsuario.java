package org.dutrilla.GestHogarOX.accion;

import com.libreriaGeneral.OX.acccionOX.OXServiceAction;
import com.libreriaGeneral.util.ConstantesGenerales;
import com.libreriaGeneral.util.GeneralUtil;
import org.dutrilla.GestHogarOX.modelo.dto.UsuarioDto;
import org.dutrilla.GestHogarOX.service.GeneralService;

import javax.ws.rs.core.Response;
import java.sql.SQLException;

public class GrabarUsuario extends OXServiceAction<UsuarioDto> {

    @Override
    protected UsuarioDto setUp() {

        return GeneralUtil.INSTANCE.parseViewAlDto(new UsuarioDto(), getView().getAllValues());
    }

    @Override
    protected Response invokeService(UsuarioDto usuarioDto) throws SQLException, IllegalAccessException {

        return GeneralService.INSTANCE.grabarUsuario(usuarioDto);
    }

    @Override
    protected void handleResponse(Response response) {

        String info = "creacionErronea";

        if (response.getEntity() != null) { info = "creacionExitosa"; }

        addInfo(info, ConstantesGenerales.OBJETO_USUARIO);

    }

    public String getNextMode() {

        return LIST;
    }
}
