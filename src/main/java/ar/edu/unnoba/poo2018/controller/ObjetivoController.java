/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.model.Objetivo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import persistencePackage.ObjetivoBean;

/**
 *
 * @author Balma
 */
@ManagedBean(name = "objetivoController")
@SessionScoped
public class ObjetivoController {

    @EJB
    private ObjetivoBean objetivob;

    private Objetivo objetivo = new Objetivo();
    private List<Objetivo> objetivos = new ArrayList<>();

    @PostConstruct
    public void init() {
        objetivo = new Objetivo();
        objetivos = new ArrayList<>();
    }

}
