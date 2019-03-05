package ar.edu.unnoba.poo2018.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    private Long id;

    private String name;
    private String password;
    private boolean administrador;
    @ManyToMany(mappedBy="responsables")
    private List<Actividad> actividadCollection;

    public Usuario() {
    }

    public Usuario(String name, String password, boolean administrador) {
        this.name = name;
        this.password = password;
        this.administrador = administrador;
    }

    @Version
    protected int version;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    @Override
	public String toString() {
		return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
	}
	
    @Override
    public int hashCode() {
        return (getName() != null) 
            ? (getClass().getSimpleName().hashCode() + getName().hashCode())
            : super.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return (other != null && getName() != null
                && other.getClass().isAssignableFrom(getClass()) 
                && getClass().isAssignableFrom(other.getClass())) 
            ? getName().equals(((Usuario) other).getName())
            : (other == this);
    }

}
