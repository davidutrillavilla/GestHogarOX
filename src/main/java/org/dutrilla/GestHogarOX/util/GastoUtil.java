package org.dutrilla.GestHogarOX.util;

import com.libreriaGeneral.dao.UtilDao;
import com.libreriaGeneral.util.GeneralUtil;
import org.dutrilla.GestHogarOX.dao.UtilGestHogarDao;
import org.dutrilla.GestHogarOX.modelo.*;
import org.dutrilla.GestHogarOX.modelo.dto.GastoDto;
import org.dutrilla.GestHogarOX.modelo.dto.ResumenMensualTotalDto;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public enum GastoUtil {

    INSTANCE;

    public Gasto crearGasto(GastoDto gastoDto) throws SQLException {

        Ciudad ciudad = obtenerCiudad(Objects.requireNonNull(UtilDao.INSTANCE.find("ciudad", gastoDto.getCiudad())));

        Establecimiento establecimiento = obtenerEstablecimiento(Objects.requireNonNull(UtilDao.INSTANCE.find("establecimiento", gastoDto.getEstablecimiento())));

        Usuario usuario = obtenerUsuario(Objects.requireNonNull(UtilDao.INSTANCE.find("usuario", gastoDto.getUsuario())));

        Gasto gasto = GeneralUtil.INSTANCE.parseDtoEntity(gastoDto, Gasto.class);

        gasto.setCiudad(ciudad);

        gasto.setNombreCiudad(ciudad.getCiudad());

        gasto.setEstablecimiento(establecimiento);

        gasto.setNombreEstablecimiento(establecimiento.getNombreEstablecimiento());

        gasto.setUsuario(usuario);

        gasto.setNombreUsuario(usuario.getNombreCompleto());

        gasto.setMes(gastoDto.getMesEnum());

        gasto.setTipoComercio(gastoDto.getTipoComercioEnum());

        gasto.setSeccionGasto(gastoDto.getSeccionGastoEnum());

        return gasto;
    }

    private Ciudad obtenerCiudad(ResultSet resultSet) throws SQLException {

        Ciudad ciudad = new Ciudad();

        ciudad.setId(resultSet.getString(1));

        ciudad.setCodigo(resultSet.getInt(2));

        ciudad.setCiudad(resultSet.getString(3));

        return ciudad;
    }

    private Establecimiento obtenerEstablecimiento(ResultSet resultSet) throws SQLException {

        Establecimiento establecimiento = new Establecimiento();

        establecimiento.setId(resultSet.getString(1));

        establecimiento.setCodigo(resultSet.getInt(2));

        establecimiento.setNombreEstablecimiento(resultSet.getString(3));

        return establecimiento;
    }

    private Usuario obtenerUsuario(ResultSet resultSet) throws SQLException {

        Usuario usuario = new Usuario();

        usuario.setId(resultSet.getString(1));

        usuario.setNombre(resultSet.getString(2));

        usuario.setPrimerApellido(resultSet.getString(3));

        usuario.setSegundoApellido(resultSet.getString(4));

        usuario.setNombreCompleto(resultSet.getString(5));

        usuario.setDni(resultSet.getString(6));

        usuario.setEjercicioNacimiento(resultSet.getInt(7));

        usuario.setAlias(resultSet.getString(8));

        usuario.setTelefono(resultSet.getString(9));

        usuario.setEmail(resultSet.getString(10));

        return usuario;
    }

    public Resultado calcularResultados(ResumenMensualTotalDto resumenMensualTotalDto) throws SQLException {

        Resultado resultado = UtilGestHogarDao.INSTANCE.calcularResultados(resumenMensualTotalDto);

        return resultado;
    }

    public ResumenMensualTotal crearResumen(Resultado resultado) {

        ResumenMensualTotal resumen = new ResumenMensualTotal();

        resumen.setId(UUID.randomUUID().toString().replace("-", ""));

        resumen.setFechaCalculo(LocalDate.now());

        resumen.setEjercicio(resultado.getEjercicio());

        resumen.setMes(resultado.getMes());

        resumen.setImporteTotal(Optional.ofNullable(resultado.getImporteTotal()).orElse(BigDecimal.ZERO));

        resumen.setImporteTotalEnCarniceria(Optional.ofNullable(resultado.getImporteTotalEnCarniceria()).orElse(BigDecimal.ZERO));

        resumen.setImporteTotalEnComprasGenericas(Optional.ofNullable(resultado.getImporteTotalEnComprasGenericas()).orElse(BigDecimal.ZERO));

        resumen.setImporteTotalEnAlimentacion(obtenerElTotalDeAlimentacion(resultado));

        resumen.setImporteTotalEnPescaderia(Optional.ofNullable(resultado.getImporteTotalEnPescaderia()).orElse(BigDecimal.ZERO));

        resumen.setImportesFijosCasa(Optional.ofNullable(resultado.getImportesFijosCasa()).orElse(BigDecimal.ZERO));

        resumen.setImporteTotalEnCalzado(Optional.ofNullable(resultado.getImporteTotalEnCalzado()).orElse(BigDecimal.ZERO));

        resumen.setImporteTotalEnRopa(Optional.ofNullable(resultado.getImporteTotalEnRopa()).orElse(BigDecimal.ZERO));

        resumen.setImporteTotalEnOcio(Optional.ofNullable(resultado.getImporteTotalEnOcio()).orElse(BigDecimal.ZERO));

        resumen.setImporteTotalEnExtraescolares(Optional.ofNullable(resultado.getImporteTotalEnExtraescolares()).orElse(BigDecimal.ZERO));

        resumen.setImporteTotalEnFarmacia(Optional.ofNullable(resultado.getImporteTotalEnFarmacia()).orElse(BigDecimal.ZERO));

        resumen.setImporteHipoteca(Optional.ofNullable(resultado.getImporteTotalEnHipoteca()).orElse(BigDecimal.ZERO));

        resumen.setImporteLuz(Optional.ofNullable(resultado.getImporteTotalEnLuz()).orElse(BigDecimal.ZERO));

        resumen.setImporteSeguros(Optional.ofNullable(resultado.getImporteTotalEnSeguros()).orElse(BigDecimal.ZERO));

        resumen.setImporteComunidad(Optional.ofNullable(resultado.getImporteTotalEnComunidad()).orElse(BigDecimal.ZERO));

        resumen.setImportesFijosCasa(obtenerElTotalDeFijosCasa(resultado));

        resumen.setGastoMercadona(Optional.ofNullable(resultado.getGastosMercadona()).orElse(BigDecimal.ZERO));

        resumen.setGastoAldi(Optional.ofNullable(resultado.getGastosAldi()).orElse(BigDecimal.ZERO));

        resumen.setGastoLidl(Optional.ofNullable(resultado.getGastosLidl()).orElse(BigDecimal.ZERO));

        resumen.setGastoAlcampo(Optional.ofNullable(resultado.getGastosAlcampo()).orElse(BigDecimal.ZERO));

        resumen.setGastoAlvimar(Optional.ofNullable(resultado.getGastosAlvimar()).orElse(BigDecimal.ZERO));

        resumen.setGastoHnosSanchez(Optional.ofNullable(resultado.getGastosHnosSanchez()).orElse(BigDecimal.ZERO));

        return resumen;
    }

    private BigDecimal obtenerElTotalDeAlimentacion(Resultado resultado) {

        BigDecimal suma = BigDecimal.ZERO;

        suma = suma.add(Optional.ofNullable(resultado.getImporteTotalEnCarniceria()).orElse(BigDecimal.ZERO));

        suma = suma.add(Optional.ofNullable(resultado.getImporteTotalEnPescaderia()).orElse(BigDecimal.ZERO));

        suma = suma.add(Optional.ofNullable(resultado.getImporteTotalEnComprasGenericas()).orElse(BigDecimal.ZERO));

        return suma;
    }

    private BigDecimal obtenerElTotalDeFijosCasa(Resultado resultado) {

        BigDecimal suma = BigDecimal.ZERO;

        suma = suma.add(Optional.ofNullable(resultado.getImporteTotalEnHipoteca()).orElse(BigDecimal.ZERO));

        suma = suma.add(Optional.ofNullable(resultado.getImporteTotalEnLuz()).orElse(BigDecimal.ZERO));

        suma = suma.add(Optional.ofNullable(resultado.getImporteTotalEnComunidad()).orElse(BigDecimal.ZERO));

        suma = suma.add(Optional.ofNullable(resultado.getImporteTotalEnSeguros()).orElse(BigDecimal.ZERO));

        return suma;
    }
}
