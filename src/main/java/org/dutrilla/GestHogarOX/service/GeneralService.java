package org.dutrilla.GestHogarOX.service;

import com.libreriaGeneral.dao.QueryConstants;
import com.libreriaGeneral.dao.UtilDao;
import com.libreriaGeneral.util.exception.ValidationErrorException;
import org.dutrilla.GestHogarOX.modelo.*;
import org.dutrilla.GestHogarOX.modelo.dto.*;
import org.dutrilla.GestHogarOX.service.validador.ValidadorGasto;
import org.dutrilla.GestHogarOX.util.GastoUtil;
import org.dutrilla.GestHogarOX.util.CiudadUtil;
import org.dutrilla.GestHogarOX.util.EstablecimientoUtil;
import org.dutrilla.GestHogarOX.util.UsuarioUtil;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

public enum GeneralService {

    INSTANCE;

    public Response grabarGasto(GastoDto gastoDto) throws SQLException, IllegalAccessException, ValidationErrorException {

        ValidadorGasto.INSTANCE.validate(gastoDto);

        Gasto gasto = GastoUtil.INSTANCE.crearGasto(gastoDto);

        UtilDao.INSTANCE.persistOrMerge(gasto);

        return Response.ok(gasto).build();
    }

    public Response grabarUsuario(UsuarioDto usuarioDto) throws SQLException, IllegalAccessException {

        Usuario usuario = UsuarioUtil.INSTANCE.crearUsuario(usuarioDto);

        UtilDao.INSTANCE.persistOrMerge(usuario);

        return Response.ok(usuario).build();
    }

    public Response grabarCiudad(CiudadDto ciudadDto) throws SQLException, IllegalAccessException {

        Ciudad ciudad = CiudadUtil.INSTANCE.crearCiudad(ciudadDto);

        UtilDao.INSTANCE.persistOrMerge(ciudad);

        return Response.ok(ciudad).build();
    }

    public Response grabarEstablecimiento(EstablecimientoDto establecimientoDto) throws SQLException, IllegalAccessException {

        Establecimiento establecimiento = EstablecimientoUtil.INSTANCE.crearEstablecimiento(establecimientoDto);

        UtilDao.INSTANCE.persistOrMerge(establecimiento);

        return Response.ok(establecimiento).build();
    }

    public Response calcularGastos(ResumenMensualTotalDto resumenMensualTotalDto) throws SQLException, IllegalAccessException {

        Resultado resultado = GastoUtil.INSTANCE.calcularResultados(resumenMensualTotalDto);

        ResumenMensualTotal resumenMensualTotal = GastoUtil.INSTANCE.crearResumen(resultado);

        UtilDao.INSTANCE.persistOrMerge(resumenMensualTotal);

        return Response.ok(resumenMensualTotal).build();
    }

    public Response eliminarGasto (GastoDto gastoDto) throws SQLException {

        UtilDao.INSTANCE.delete(QueryConstants.TABLA_GASTO, gastoDto.getId());

        return Response.ok(true).build();
    }

    public Response eliminarEstablecimiento (EstablecimientoDto establecimientoDto) throws SQLException {

        UtilDao.INSTANCE.delete(QueryConstants.TABLA_ESTABLECIMIENTO, establecimientoDto.getId());

        return Response.ok(true).build();
    }

    public Response eliminarCiudad (CiudadDto ciudadDto) throws SQLException {

        UtilDao.INSTANCE.delete(QueryConstants.TABLA_CIUDAD, ciudadDto.getId());

        return Response.ok(true).build();
    }

    public Response eliminarResumenMensual (ResumenMensualTotalDto resumenMensualTotalDto) throws SQLException {

        UtilDao.INSTANCE.delete(QueryConstants.TABLA_RESUMEN, resumenMensualTotalDto.getId());

        return Response.ok(true).build();
    }

    public Response eliminarUsuario (UsuarioDto usuarioDto) throws SQLException {

        UtilDao.INSTANCE.delete(QueryConstants.TABLA_USUARIO, usuarioDto.getId());

        return Response.ok(true).build();
    }
}
