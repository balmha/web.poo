package ar.edu.unnoba.poo2018.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Convocatorias")
public class Convocatoria {
	
	@Id
        @GeneratedValue
	private long nro;
	
	private String nombre;
	
	@Version
	protected int version;

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
		return "Convocatoria [nro=" + nro + ", nombre=" + nombre + "]";
	}
	
}
