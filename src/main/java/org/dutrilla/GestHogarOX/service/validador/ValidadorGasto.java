package org.dutrilla.GestHogarOX.service.validador;

import com.libreriaGeneral.util.Condition;
import com.libreriaGeneral.util.exception.ValidationErrorException;
import com.libreriaGeneral.util.validador.BeanValidator;
import com.libreriaGeneral.util.validador.IServiceValidator;
import org.dutrilla.GestHogarOX.modelo.Gasto;
import org.dutrilla.GestHogarOX.modelo.dto.GastoDto;

import java.sql.SQLException;

public enum ValidadorGasto implements IServiceValidator<GastoDto> {

    INSTANCE;

    @Override
    public void validate(GastoDto dto) throws ValidationErrorException, SQLException {

        BeanValidator.validateAllRequiredValues(dto);

        if (!Condition.empty(dto.getId()))
            BeanValidator.validateNotNullReference(Gasto.class, dto.getId(),
                                                   String.format(BeanValidator.FORMAT_ERROR_REFERENCIA_NULO, Gasto.class.getSimpleName(), dto.getId()));
    }
}
