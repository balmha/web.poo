package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.model.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import persistencePackage.UsuarioBean;

/**
 *
 * @author Balma
 */
@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController {

    @EJB
    private UsuarioBean userb;
    private boolean administrador;
    private String name;
    private String password;

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "logout";
    }

    public String login() {
        Usuario authuser = userb.findByUser(name, password);
        if (authuser != null) {
            if (authuser.isAdministrador() == true) {
                return "successAdmin";
            } else {
                return "successUser";
            }
        }
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "invalid";
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

}