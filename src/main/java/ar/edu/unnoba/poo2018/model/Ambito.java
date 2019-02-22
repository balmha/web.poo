package ar.edu.unnoba.poo2018.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "ambito")
public class Ambito {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
        return "Ambito [nro=" + nro + ", nombre=" + nombre + "]";
    }

}
