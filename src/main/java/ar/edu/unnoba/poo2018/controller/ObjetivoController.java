    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.model.Objetivo;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import persistencePackage.ObjetivoBean;

/**
 *
 * @author Balma
 */
@ManagedBean
@SessionScoped
public class ObjetivoController implements Serializable {

    @EJB
    private ObjetivoBean objetivob;
    private String nombre;
    private String nombreUpdate;
    private List<Objetivo> objetivosList;

    public String save() {
        objetivob.create(new Objetivo(nombre));
        return "successSave";
    }

    public List getObjetivos() {
        objetivosList = objetivob.getObjetivos();
        if (objetivosList != null) {
            return objetivosList;
        } else {
            return objetivosList;
        }
    }

    public String deleteObjetivo(Objetivo o) {
        objetivob.remove(o);
        return null;
    }

    public String editAction(Objetivo o) {
        o.setEditable(true);
        objetivob.Update(o);
        return null;
    }

    public String saveUpdate(Objetivo o, String updatenom) {
        o.setNombre(updatenom);
        o.setEditable(false);
        objetivob.Update(o);
        return null;
    }

    public String getNombreUpdate() {
        return nombreUpdate;
    }

    public void setNombreUpdate(String nombreUpdate) {
        this.nombreUpdate = nombreUpdate;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
