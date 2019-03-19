/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.model.Actividad;
import ar.edu.unnoba.poo2018.model.Ambito;
import ar.edu.unnoba.poo2018.model.Compuesto;
import ar.edu.unnoba.poo2018.model.Convocatoria;
import ar.edu.unnoba.poo2018.model.Impacto;
import ar.edu.unnoba.poo2018.model.LineaEstrategica;
import ar.edu.unnoba.poo2018.model.Objetivo;
import ar.edu.unnoba.poo2018.model.Simple;
import ar.edu.unnoba.poo2018.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import persistencePackage.ActividadBean;
import persistencePackage.CompuestoBean;
import persistencePackage.SimpleBean;

/**
 *
 * @author Balma
 */
@ManagedBean
@SessionScoped
public class ActividadController implements Serializable {

    @EJB
    private ActividadBean actividadb;
    @EJB
    private SimpleBean simpleb;
    @EJB
    private CompuestoBean compuestob;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private String resolucion;
    private String expediente;
    private Convocatoria convocatoria;
    private LineaEstrategica linea;
    private Ambito ambito;
    private List<Usuario> responsables = new ArrayList<>();
    private List<Impacto> impactos = new ArrayList<>();
    
    private Simple selectedSimple;
    private Compuesto selectedCompuesto;

    private List<Simple> actividadesSimples = new ArrayList<>();
    private List<Compuesto> actividadesCompuestas = new ArrayList<>();
    private List<Actividad> getActividad = new ArrayList<>();
    private List<Actividad> listaActividades = new ArrayList<>();

    public String save() {
        Simple s = new Simple(nombre,fechaInicio,fechaFin,resolucion,expediente,convocatoria,linea,ambito,responsables,impactos);
        simpleb.create(s);
        return "SuccessSave";
    }
    
    public String saveCompuesto() {
        Compuesto c = new Compuesto(nombre,fechaInicio,fechaFin,resolucion,expediente,convocatoria,linea,ambito,responsables,listaActividades);
        compuestob.create(c);
        return "SuccessSave";
    }
    
    public List getActividadesSimples(Long id) {
        actividadesSimples = simpleb.getActividades(id);
        if (actividadesSimples != null) {
            return actividadesSimples;
        } else {
            return actividadesSimples;
        }
    }
    
    public List getActividades(Long id) {
        getActividad = actividadb.getActividades(id);
        if (getActividad != null) {
            return getActividad;
        } else {
            return getActividad;
        }
    }
    
    public List getActividadesCompuestas(Long id) {
        actividadesCompuestas = compuestob.getActividades(id);
        if (actividadesCompuestas != null) {
            return actividadesCompuestas;
        } else {
            return actividadesCompuestas;
        }
    }

    public Convocatoria[] getConvocatorias() {
        return null;
    }

    public Ambito[] getAmbitos() {
        return null;
    }

    public LineaEstrategica[] getLineasEstrategicas() {
        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public Convocatoria getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(Convocatoria convocatoria) {
        this.convocatoria = convocatoria;
    }

    public LineaEstrategica getLinea() {
        return linea;
    }

    public void setLinea(LineaEstrategica linea) {
        this.linea = linea;
    }

    public Ambito getAmbito() {
        return ambito;
    }

    public void setAmbito(Ambito ambito) {
        this.ambito = ambito;
    }

    public List<Usuario> getResponsables() {
        return responsables;
    }

    public void setResponsables(List<Usuario> responsables) {
        this.responsables = responsables;
    }

    public List<Impacto> getImpactos() {
        return impactos;
    }

    public void setImpactos(List<Impacto> impactos) {
        this.impactos = impactos;
    }

    public List<Actividad> getListaActividades() {
        return listaActividades;
    }

    public void setListaActividades(List<Actividad> listaActividades) {
        this.listaActividades = listaActividades;
    }

    public List<Simple> getActividadesSimples() {
        return actividadesSimples;
    }
    
    public String addImpactos(Objetivo o, int peso){
        Impacto i = new Impacto(peso,o);
        impactos.add(i);
        return null;
    }

    public Simple getSelectedSimple() {
        return selectedSimple;
    }

    public void setSelectedSimple(Simple selectedSimple) {
        this.selectedSimple = selectedSimple;
    }

    public Compuesto getSelectedCompuesto() {
        return selectedCompuesto;
    }

    public void setSelectedCompuesto(Compuesto selectedCompuesto) {
        this.selectedCompuesto = selectedCompuesto;
    }
    
}
