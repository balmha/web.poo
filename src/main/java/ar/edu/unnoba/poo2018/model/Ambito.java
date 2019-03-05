package ar.edu.unnoba.poo2018.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Ambito")
public class Ambito implements Serializable {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    private Long nro;

    private String nombre;

    @Version
    protected int version;

    public Ambito() {
    }

    public Ambito(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getNro() {
        return nro;
    }

    public void setNro(long nro) {
        this.nro = nro;
    }

    @Override
	public String toString() {
		return String.format("%s[id=%d]", getClass().getSimpleName(), getNro());
	}
	
    @Override
    public int hashCode() {
        return (getNombre() != null) 
            ? (getClass().getSimpleName().hashCode() + getNombre().hashCode())
            : super.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return (other != null && getNombre() != null
                && other.getClass().isAssignableFrom(getClass()) 
                && getClass().isAssignableFrom(other.getClass())) 
            ? getNombre().equals(((Ambito) other).getNombre())
            : (other == this);
    }

}
