package org.dutrilla.GestHogarOX.accion;

import com.libreriaGeneral.OX.acccionOX.OXServiceAction;
import com.libreriaGeneral.util.GeneralUtil;
import org.dutrilla.GestHogarOX.modelo.dto.TestDto;

import javax.ws.rs.core.Response;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CapturarTest extends OXServiceAction<TestDto> {

    @Override
    protected TestDto setUp() {

        Map<String, Object> map = getView().getValues();

        TestDto testDto = new TestDto();

        System.out.println(map.size());

    //    List<String> listaClaves = GeneralUtil.INSTANCE.capturarClaves(getView().getValues());

  //      listaClaves.size();

 //       GeneralUtil.INSTANCE.imprimirListado(listaClaves);

        System.out.println("Imprimir el listado de claves");

        for(String clave: map.keySet()) {

            System.out.println(clave + " - " + map.get(clave).toString());





        }

        GeneralUtil.INSTANCE.parseViewAlDto(testDto, map);

        System.out.println(testDto.getId() + " " + testDto.getTexto() + " " + testDto.getFecha() + " " + testDto.getNumero() + " " + testDto.getValor());

        return testDto;
    }

    @Override
    protected Response invokeService(TestDto testDto) throws SQLException, IllegalAccessException {
        return Response.ok().build();
    }

    @Override
    protected void handleResponse(Response response) {

    }


}
