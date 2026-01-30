package org.dutrilla.GestHogarOX.modelo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter @Setter
@SuperBuilder
public class ResumenMensualTotalDto {

    private String id;

    private int ejercicio;

    private String mes;

    private String usuario;
}
