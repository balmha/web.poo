/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.model.LineaEstrategica;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import persistencePackage.LineaEstrategicaBean;

/**
 *
 * @author Balma
 */
@ManagedBean(name = "lineaEstrategicaController")
@ViewScoped
public class LineaEstrategicaController {

    @EJB
    private LineaEstrategicaBean lineaEstrategicab;
    private String nombre;
    private List<LineaEstrategica> lineasList;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void save() {
        lineaEstrategicab.create(new LineaEstrategica(nombre));
        this.nombre = null;
    }

    public List getLineas() {
        lineasList = lineaEstrategicab.getLineas();
        if (lineasList != null) {
            return lineasList;
        } else {
            System.out.println("Se pudrió todo");
            return lineasList;
        }
    }

}
