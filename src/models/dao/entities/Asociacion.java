package models.dao.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Asociacion
 * 
 */
@Entity
public class Asociacion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    int id;

    @ManyToMany(mappedBy = "asociaciones")
    @JoinColumn
    private Collection<Socio> socios = new HashSet<Socio>();

    protected int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    protected Collection<Socio> getSocios() {
        return socios;
    }

    protected void setSocios(Collection<Socio> socios) {
        this.socios = socios;
    }
    
    // ...

}
