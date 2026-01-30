package org.dutrilla.GestHogarOX.modelo;

import com.libreriaGeneral.dao.UtilDao;
import lombok.Getter;
import lombok.Setter;
import org.dutrilla.GestHogarOX.dao.UtilGestHogarDao;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.Tab;
import org.openxava.annotations.View;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.UUID;

@Tab(name = "ciudad", properties = "codigo, ciudad")
@View(name = "ciudad", members = "codigo, ciudad")
@View(name = "nuevo", members = "ciudad")
@View(name = "vistaDeGasto", members = "ciudad")
@Getter @Setter
@Entity
@Table(schema = "dutrilla_gestion", name = "ciudad")
public class Ciudad implements Serializable {

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

    @Column(name = "ciudad", length = 30)
    private String ciudad;
}
