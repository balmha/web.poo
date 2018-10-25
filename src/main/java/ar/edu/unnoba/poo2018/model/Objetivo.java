package ar.edu.unnoba.poo2018.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Objetivos")
public class Objetivo {
	
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
	public boolean equals(Object obj) {
		if(this == obj)
				return true;
		return nombre.equals(((Objetivo)obj).getNombre());
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
