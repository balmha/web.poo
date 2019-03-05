package ar.edu.unnoba.poo2018.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Objetivo")
public class Objetivo implements Serializable{

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    private Long nro;
    
    private String nombre;
    boolean editable;

    public Objetivo() {
    }

    public Objetivo(String nombre) {
        this.nombre = nombre;
    }

    @Version
    protected int version;

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public long getNro() {
        return nro;
    }

    public void setNro(long nro) {
        this.nro = nro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return nombre.equals(((Objetivo) obj).getNombre());
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }

    @Override
    public String toString() {
        return "Objetivo [nro=" + nro + ", nombre=" + nombre + "]";
    }

}
