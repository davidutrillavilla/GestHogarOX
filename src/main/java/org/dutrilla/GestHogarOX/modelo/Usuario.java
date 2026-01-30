package org.dutrilla.GestHogarOX.modelo;

import groovy.util.logging.Slf4j;
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.Required;
import org.openxava.annotations.Tab;
import org.openxava.annotations.View;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Tab(name = "usuario", properties = "nombreCompleto, dni")
@View(name= "nuevo", members = "ejercicioNacimiento;" +
                               "dni;" +
                               "alias;" +
                               "nombre, primerApellido, segundoApellido;" +
                               "telefono, email")
@View(name = "vistaDeGasto", members = "nombreCompleto")
@Entity
@Slf4j
@Getter
@Setter
@Table(schema = "dutrilla_gestion", name = "usuario")
public class Usuario implements Serializable {

    @PrePersist
    private void setId(){

        setId(UUID.randomUUID().toString().replace("-", ""));
    }

    @Id
    @Hidden
    @Column(name = "id", length = 32, updatable = false, insertable = true)
    private String id;

    @Required
    @Column(name = "nombre", length = 30, nullable = false)
    private String nombre;

    @Required
    @Column(name = "primerapellido", length = 30, nullable = false)
    private String primerApellido;

    @Required
    @Column(name = "segundoapellido", length = 30, nullable = false)
    private String segundoApellido;

    @Column(name = "nombrecompleto", length = 50)
    private String nombreCompleto;

    @Required
    @Column(name = "dni", length = 9, nullable = false)
    private String dni;

    @Required
    @Column(name = "ejercicionacimiento", length = 4, nullable = false)
    private int ejercicioNacimiento;

    @Column(name = "alias", length = 30, nullable = false)
    private String alias;


    @Column(name = "telefono", length = 9, nullable = false)
    private String telefono;


    @Column(name = "email", length = 60, nullable = false)
    private String email;

    public String toString() { return nombreCompleto; }
}
