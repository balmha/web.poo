package ar.edu.unnoba.poo2018.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Lineas")
public class LineaEstrategica {

	@Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long nro;
	
	private String nombre;
	
	@Version
	protected int version;

    public LineaEstrategica() {
    }

    public LineaEstrategica(String nombre) {
        this.nombre = nombre;
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
    public String toString() {
        return "LineaEstrategica [nro=" + nro + ", nombre=" + nombre + "]";
    }

}
