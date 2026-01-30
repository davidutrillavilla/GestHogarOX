package org.dutrilla.GestHogarOX.modelo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter @Setter
public class UsuarioDto {

    private String id;

    private String nombre;

    private String primerApellido;

    private String segundoApellido;

    private String dni;

    private int ejercicioNacimiento;

    private String alias;

    private String telefono;

    private String email;
}
