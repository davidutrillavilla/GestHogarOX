package org.dutrilla.GestHogarOX.modelo;

import groovy.util.logging.Slf4j;
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Required;
import org.openxava.annotations.Tab;
import org.openxava.annotations.View;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Tab(name = "USERPASSWORD", properties = "usuario")
@View(name = "USERPASSWORD", members = "usuario, password")
@Entity
@Slf4j
@Getter
@Setter
@Table(schema = "dutrilla_gestion", name = "userpassword")
public class UserPassword implements Serializable {

    @PrePersist
    private void setId(){

        id = UUID.randomUUID().toString().replace("-", "");
    }

    @Id
    @Column(name = "id", length = 32, nullable = false)
    private String id;

    @Required
    @Column(name = "usuario", length = 30)
    private String usuario;

    @Required
    @Column(name = "password", length = 100)
    private String password;
}
