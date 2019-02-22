package ar.edu.unnoba.poo2018.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String password;
    private boolean administrador;

    public Usuario() {
    }

    public Usuario(String name, String password, boolean administrador) {
        this.name = name;
        this.password = password;
        this.administrador = administrador;
    }

    @Version
    protected int version;

    public long getId() {
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
        return "Usuario [nombre=" + name + ", password=" + password + ", administrador=" + administrador + "]";
    }

}
