package org.dutrilla.GestHogarOX.modelo;


import com.libreriaGeneral.dao.UtilDao;
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.Tab;
import org.openxava.annotations.View;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.UUID;

@Tab(name = "establecimiento", properties = "codigo, nombreEstablecimiento")
@View(name = "establecimiento", members = "nombreEstablecimiento")
@View(name = "nuevo", members = "nombreEstablecimiento")
@View(name = "vistaDeGasto", members = "nombreEstablecimiento")
@Getter @Setter
@Entity
@Table(schema = "dutrilla_gestion", name = "establecimiento")
public class Establecimiento implements Serializable {

    @PrePersist
    private void setId() throws SQLException {

        setId(UUID.randomUUID().toString().replace("-", ""));

        setCodigo(UtilDao.INSTANCE.getCodigoInsercion(this));
    }

    @Id
    @Hidden
    @Column(name = "id", length = 32)
    private String id;

    @Column(name = "codigo", length = 2)
    private int codigo;

    @Column(name = "nombreEstablecimiento", length = 30)
    private String nombreEstablecimiento;

    public String toString() {
        return nombreEstablecimiento;
    }
}
