package org.dutrilla.GestHogarOX.modelo;

import lombok.Getter;

@Getter
public enum TipoComercio {

    PESCADERIA("PE", 1),

    CARNICERIA("CA", 2),

    GENERAL("GE", 3),

    PROVEEDOR_SERVICIOS("PR", 4),

    GASTOS_INMUEBLE("IN", 5);

    private String descripcion;

    private int codigoIdentificador;

    private TipoComercio(String descripcion, int codigoIdentificador){

        this.descripcion = descripcion;

        this.codigoIdentificador = codigoIdentificador;
    }

    public String getDescripcion() {

        return descripcion;
    }
}
