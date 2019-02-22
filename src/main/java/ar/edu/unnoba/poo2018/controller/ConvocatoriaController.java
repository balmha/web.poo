/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.model.Convocatoria;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import persistencePackage.ConvocatoriaBean;

/**
 *
 * @author Balma
 */
@ManagedBean(name = "convocatoriaController")
@ViewScoped
public class ConvocatoriaController {

    @EJB
    private ConvocatoriaBean convocatoriab;
    private String nombre;
    private List<Convocatoria> convocatoriasList;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void save() {
        convocatoriab.create(new Convocatoria(nombre));
        this.nombre = null;
    }

    public List getConvocatorias() {
        convocatoriasList = convocatoriab.getConvocatorias();
        if (convocatoriasList != null) {
            return convocatoriasList;
        } else {
            System.out.println("Se pudrió todo");
            return convocatoriasList;
        }
    }

}
