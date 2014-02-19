package basic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ENTITY_UNO")
public class Entity1 implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "NOMBRE", unique = true, nullable = false)
    private String name;
    @Transient
    private int noPersistente;

    public Entity1() {
        super();
    }

    public Entity1(int id, String name, int noPersistente) {
        this.id = id;
        this.name = name;
        this.noPersistente = noPersistente;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoPersistente() {
        return this.noPersistente;
    }

    public void setNoPersistente(int noPersistente) {
        this.noPersistente = noPersistente;
    }

}
