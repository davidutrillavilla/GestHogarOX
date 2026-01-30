package org.dutrilla.GestHogarOX.accion;

import com.libreriaGeneral.OX.acccionOX.OXServiceAction;
import com.libreriaGeneral.util.ConstantesGenerales;

import com.libreriaGeneral.util.GeneralUtil;
import lombok.Getter;
import lombok.Setter;

import org.dutrilla.GestHogarOX.modelo.dto.GastoDto;
import org.dutrilla.GestHogarOX.service.GeneralService;;

import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;

@Getter @Setter
public class GrabarGasto extends OXServiceAction<GastoDto> {

    @Override
    protected GastoDto setUp() {

        return GeneralUtil.INSTANCE.parseViewAlDto(new GastoDto(), getView().getAllValues());
    }

    @Override
    protected Response invokeService(GastoDto gastoDto) throws SQLException, IllegalAccessException {

        return GeneralService.INSTANCE.grabarGasto(gastoDto);
    }

    @Override
    protected void handleResponse(Response response) {

        String info ="creacionErronea";

        if (response.getEntity() != null) { info = "creacionExitosa"; }

        addInfo(info, ConstantesGenerales.OBJETO_GASTO);
    }

    public String getNextMode() {

        return LIST;
    }
}
