/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ejb.EJB;
import persistencePackage.UsuarioBean;

/**
 *
 * @author Balma
 */
@ManagedBean
@RequestScoped
public class UsuarioController implements Serializable{

    @EJB
    private UsuarioBean userb;
    private boolean administrador;
    private String name;
    private String password;
    private List<Usuario> usuariosList;

    public String register() {
        userb.create(new Usuario(name, password, administrador));
        return "success";
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
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
    
    public List getUsuarios() {
        usuariosList = userb.getAll();
        if (usuariosList != null) {
            return usuariosList;
        } else {
            return usuariosList;
        }
    }
}
