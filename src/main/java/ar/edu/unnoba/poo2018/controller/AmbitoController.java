/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.model.Ambito;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import persistencePackage.AmbitoBean;

/**
 *
 * @author Balma
 */
@ManagedBean(name = "ambitoController")
@ViewScoped
public class AmbitoController {

    @EJB
    private AmbitoBean ambitob;
    private String nombre;
    private List<Ambito> ambitosList;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void save() {
        ambitob.create(new Ambito(nombre));
        this.nombre = null;
    }

    public List getAmbitos() {
        ambitosList = ambitob.getAmbitos();
        if (ambitosList != null) {
            return ambitosList;
        } else {
            System.out.println("Se pudrió todo");
            return ambitosList;
        }
    }

}
