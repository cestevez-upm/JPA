package models.dao.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Socio
 * 
 */
@Entity
public class Socio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    int id;

    @ManyToMany
    @JoinColumn
    private Collection<Asociacion> asociaciones = new HashSet<Asociacion>();
    // ...

    protected int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    protected Collection<Asociacion> getAsociaciones() {
        return asociaciones;
    }

    protected void setAsociaciones(Collection<Asociacion> asociaciones) {
        this.asociaciones = asociaciones;
    }

}
