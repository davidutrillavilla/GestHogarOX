package org.dutrilla.GestHogarOX.dao;

import com.libreriaGeneral.dao.DataBaseManager;
import com.libreriaGeneral.dao.QueryConstants;
import com.libreriaGeneral.dao.UtilDao;
import com.libreriaGeneral.util.ConstantesGenerales;

import org.dutrilla.GestHogarOX.modelo.Gasto;
import org.dutrilla.GestHogarOX.modelo.Resultado;
import org.dutrilla.GestHogarOX.modelo.dto.MensualidadDto;
import org.dutrilla.GestHogarOX.modelo.dto.ResumenMensualTotalDto;

import javax.persistence.PrePersist;
import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public enum UtilGestHogarDao {

    INSTANCE;

    private Logger log = Logger.getLogger("log");

    private String getWhereTotal(int ejercicio, String mes) {

        return String.format(QueryConstants.SQL_WHERE_TOTAL, ejercicio, mes);
    }

    private String getWhereTotalTipoComercio(int ejercicio, String mes, String tipoComercio) {

        return String.format(QueryConstants.SQL_WHERE_TOTAL_TIPO_COMERCIO, ejercicio, mes, tipoComercio);
    }

    private String getWhereSeccion(int ejercicio, String mes, String seccion) {

        return String.format(QueryConstants.SQL_WHERE_TOTAL_SECCION, ejercicio, mes, seccion);
    }

    private String getWhereSupercado(int ejercicio, String mes, String supermercado) {

        return String.format(QueryConstants.SQL_WHERE_SUPERMERCADO, ejercicio, mes, supermercado);
    }

    private BigDecimal calcular(DataBaseManager dataBaseManager, StringBuilder sql) throws SQLException {

        PreparedStatement preparedStatement = dataBaseManager.prepareStatement(sql.toString());

        sql.setLength(0);

        ResultSet rs = preparedStatement.executeQuery();

        rs.next();

        return (BigDecimal) rs.getObject(1);
    }


    public Resultado calcularResultados (ResumenMensualTotalDto resumenMensualTotalDto) throws SQLException {

        Resultado resultado = new Resultado();

        resultado.setEjercicio(resumenMensualTotalDto.getEjercicio());

        resultado.setMes(resumenMensualTotalDto.getMes());

        DataBaseManager dataBaseManager = UtilDao.INSTANCE.getDataBaseManager();

        String schema = ConstantesGenerales.SCHEMA_GENERAL;

        String tableName = ConstantesGenerales.TABLA_BASE_CALCULOS;

        StringBuilder sql = new StringBuilder();

        List<String> whereCalculos = obtenerWhereCalculos(resumenMensualTotalDto);

        List<String> whereSecciones = obtenerWhereSecciones(resumenMensualTotalDto);

        List<String> whereSupermercados = obtenerWhereSupermercados(resumenMensualTotalDto);

        try {

            obtenerCalculosPorTipos(whereCalculos, sql, schema,tableName, dataBaseManager, resultado);

            obtenerCalculosPorSeccion(whereSecciones, sql, schema, tableName, dataBaseManager, resultado);

            obtenerCalculosPorSupermercado(whereSupermercados, sql, schema, tableName, dataBaseManager, resultado);

        } catch (Exception e) {

            log.info(ConstantesGenerales.ERROR_CONSULTA_CODIGO + e);

        }

        return resultado;
    }

    private List obtenerWhereCalculos(ResumenMensualTotalDto resumenMensualTotalDto) {

        List<String> whereCalculos = new ArrayList<>();

        whereCalculos.add(getWhereTotal(resumenMensualTotalDto.getEjercicio(), resumenMensualTotalDto.getMes()));

        whereCalculos.add(getWhereTotalTipoComercio(resumenMensualTotalDto.getEjercicio(), resumenMensualTotalDto.getMes(), QueryConstants.TIPO_CARNICERIA));

        whereCalculos.add(getWhereTotalTipoComercio(resumenMensualTotalDto.getEjercicio(), resumenMensualTotalDto.getMes(), QueryConstants.TIPO_PESCADERIA));

        whereCalculos.add(getWhereTotalTipoComercio(resumenMensualTotalDto.getEjercicio(), resumenMensualTotalDto.getMes(), QueryConstants.TIPO_GENERAL));

        return whereCalculos;
    }

    private List obtenerWhereSecciones(ResumenMensualTotalDto resumenMensualTotalDto) {

        List<String> whereSecciones = new ArrayList<>();

        whereSecciones.add(getWhereSeccion(resumenMensualTotalDto.getEjercicio(), resumenMensualTotalDto.getMes(), QueryConstants.SECCION_ROPA));

        whereSecciones.add(getWhereSeccion(resumenMensualTotalDto.getEjercicio(), resumenMensualTotalDto.getMes(), QueryConstants.SECCION_CALZADO));

        whereSecciones.add(getWhereSeccion(resumenMensualTotalDto.getEjercicio(), resumenMensualTotalDto.getMes(), QueryConstants.SECCION_EXTRAESCOLARES));

        whereSecciones.add(getWhereSeccion(resumenMensualTotalDto.getEjercicio(), resumenMensualTotalDto.getMes(), QueryConstants.SECCION_OCIO));

        whereSecciones.add(getWhereSeccion(resumenMensualTotalDto.getEjercicio(), resumenMensualTotalDto.getMes(), QueryConstants.SECCION_HIPOTECA));

        whereSecciones.add(getWhereSeccion(resumenMensualTotalDto.getEjercicio(), resumenMensualTotalDto.getMes(), QueryConstants.SECCION_LUZ));

        whereSecciones.add(getWhereSeccion(resumenMensualTotalDto.getEjercicio(), resumenMensualTotalDto.getMes(), QueryConstants.SECCION_COMUNIDAD));

        whereSecciones.add(getWhereSeccion(resumenMensualTotalDto.getEjercicio(), resumenMensualTotalDto.getMes(), QueryConstants.SECCION_SEGUROS));

        whereSecciones.add(getWhereSeccion(resumenMensualTotalDto.getEjercicio(), resumenMensualTotalDto.getMes(), QueryConstants.SECCION_FARMACIA));

        return whereSecciones;
    }

    private List obtenerWhereSupermercados(ResumenMensualTotalDto resumenMensualTotalDto) {

        List<String> whereSupermercados = new ArrayList<>();

        whereSupermercados.add(getWhereSupercado(resumenMensualTotalDto.getEjercicio(), resumenMensualTotalDto.getMes(), QueryConstants.SUPERMERCADO_MERCADONA));

        whereSupermercados.add(getWhereSupercado(resumenMensualTotalDto.getEjercicio(), resumenMensualTotalDto.getMes(), QueryConstants.SUPERMERCADO_ALDI));

        whereSupermercados.add(getWhereSupercado(resumenMensualTotalDto.getEjercicio(), resumenMensualTotalDto.getMes(), QueryConstants.SUPERMERCADO_LIDL));

        whereSupermercados.add(getWhereSupercado(resumenMensualTotalDto.getEjercicio(), resumenMensualTotalDto.getMes(), QueryConstants.SUPERMERCADO_ALCAMPO));

        whereSupermercados.add(getWhereSupercado(resumenMensualTotalDto.getEjercicio(), resumenMensualTotalDto.getMes(), QueryConstants.SUPERMERCADO_ALVIMAR));

        whereSupermercados.add(getWhereSupercado(resumenMensualTotalDto.getEjercicio(), resumenMensualTotalDto.getMes(), QueryConstants.SUPERMERCADO_HNOSSANCHEZ));

        return whereSupermercados;
    }

    private void obtenerCalculosPorTipos(List<String> listaWhere, StringBuilder sql, String schema, String tabla, DataBaseManager dataBaseManager, Resultado resultado) throws SQLException {

        List<BigDecimal> resultadosPorTipo = new ArrayList<>();

        for (int i = 0; i < listaWhere.size(); i++) {

            sql.append(QueryConstants.SQL_SELECT_FROM_TOTAL + schema + tabla + " " + listaWhere.get(i));

            resultadosPorTipo.add(i, calcular(dataBaseManager, sql));
        }

        transferirDatosAlResultado(resultado, resultadosPorTipo);
    }

    private void transferirDatosAlResultado(Resultado resultado, List<BigDecimal> resultadosPorTipo) {

        resultado.setImporteTotal(resultadosPorTipo.get(0));

        resultado.setImporteTotalEnCarniceria(resultadosPorTipo.get(1));

        resultado.setImporteTotalEnPescaderia(resultadosPorTipo.get(2));

        resultado.setImporteTotalEnComprasGenericas(resultadosPorTipo.get(3));
    }

    private void obtenerCalculosPorSeccion(List<String> listaWhere, StringBuilder sql, String schema, String tabla, DataBaseManager dataBaseManager, Resultado resultado) throws SQLException {

        List<BigDecimal> resultadosPorSeccion = new ArrayList<>();

        for (int i = 0; i < listaWhere.size(); i++) {

            sql.append(QueryConstants.SQL_SELECT_FROM_TOTAL + schema + tabla + " " + listaWhere.get(i));

            resultadosPorSeccion.add(i, calcular(dataBaseManager, sql));
        }

        transferirDatosPorSeccionAlResultado(resultado, resultadosPorSeccion);
    }

    private void obtenerCalculosPorSupermercado(List<String> listaWhere, StringBuilder sql, String schema, String tabla, DataBaseManager dataBaseManager, Resultado resultado) throws SQLException {

        List<BigDecimal> resultadosPorSupermercado = new ArrayList<>();

        for (int i = 0; i < listaWhere.size(); i++) {

            sql.append(QueryConstants.SQL_SELECT_FROM_TOTAL + schema + tabla + " " + listaWhere.get(i));

            resultadosPorSupermercado.add(i, calcular(dataBaseManager, sql));
        }

        transferirDatosPorSupermercadoAlResultado(resultado, resultadosPorSupermercado);
    }

    private void transferirDatosPorSeccionAlResultado(Resultado resultado, List<BigDecimal> resultadosPorSeccion) {

        resultado.setImporteTotalEnRopa(resultadosPorSeccion.get(0));
        resultado.setImporteTotalEnCalzado(resultadosPorSeccion.get(1));
        resultado.setImporteTotalEnExtraescolares(resultadosPorSeccion.get(2));
        resultado.setImporteTotalEnOcio(resultadosPorSeccion.get(3));
        resultado.setImporteTotalEnHipoteca(resultadosPorSeccion.get(4));
        resultado.setImporteTotalEnLuz(resultadosPorSeccion.get(5));
        resultado.setImporteTotalEnComunidad(resultadosPorSeccion.get(6));
        resultado.setImporteTotalEnSeguros(resultadosPorSeccion.get(7));
        resultado.setImporteTotalEnFarmacia(resultadosPorSeccion.get(8));
    }

    private void transferirDatosPorSupermercadoAlResultado(Resultado resultado, List<BigDecimal> resultadosPorSupermercado) {

        resultado.setGastosMercadona(resultadosPorSupermercado.get(0));
        resultado.setGastosAldi(resultadosPorSupermercado.get(1));
        resultado.setGastosLidl(resultadosPorSupermercado.get(2));
        resultado.setGastosAlcampo(resultadosPorSupermercado.get(3));
        resultado.setGastosAlvimar(resultadosPorSupermercado.get(4));
        resultado.setGastosHnosSanchez(resultadosPorSupermercado.get(5));

    }
}
