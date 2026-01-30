package org.dutrilla.GestHogarOX.util;

import com.libreriaGeneral.util.GeneralUtil;
import org.dutrilla.GestHogarOX.modelo.Usuario;
import org.dutrilla.GestHogarOX.modelo.dto.UsuarioDto;

public enum UsuarioUtil {

    INSTANCE;

    public Usuario crearUsuario(UsuarioDto usuarioDto) {

        Usuario usuario = GeneralUtil.INSTANCE.parseDtoEntity(usuarioDto, Usuario.class);

        usuario.setNombreCompleto(usuarioDto.getNombre() + " " + usuarioDto.getPrimerApellido() + " " + usuarioDto.getSegundoApellido());

        return usuario;
    }
}
