/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ejb.EJB;
import persistencePackage.UsuarioBean;

/**
 *
 * @author Balma
 */
@ManagedBean(name = "usuarioController")
@RequestScoped
public class UsuarioController {

    @EJB
    private UsuarioBean userb;

    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios = new ArrayList<>();

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        usuarios = new ArrayList<>();
    }

    public String register() {
        userb.create(usuario);
        return "success";
    }

    public String logout() {
        System.out.println("Desloguearse");
        return "inicio.xhtml?faces-redirect=true";
    }

    public String inicio() {
        return "inicio.xhtml?faces-redirect=true";
    }

    public String login() {
        Usuario authuser = userb.findByUser(usuario.getName(), usuario.getPassword());
        if (authuser != null) {
            return "success";
        }
        return "invalid";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
