/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencePackage;

import ar.edu.unnoba.poo2018.model.LineaEstrategica;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Balma
 */
@Stateless
public class LineaEstrategicaBean {

    @PersistenceContext(unitName = "webpoo")
    EntityManager em;

    public void create(LineaEstrategica linea) {
        em.persist(linea);
    }

    public void Update(LineaEstrategica linea) {
        em.merge(linea);
    }

    public void remove(LineaEstrategica linea) {
        em.remove(em.merge(linea));
    }

    public LineaEstrategica find(Object nro) {
        return em.find(LineaEstrategica.class, nro);
    }

    public List getLineas() {
        Query query = em.createQuery("SELECT l FROM LineaEstrategica l");
        List<LineaEstrategica> lineasList;
        try {
            lineasList = query.getResultList();
        } catch (Exception e) {
            lineasList = null;
        }
        return lineasList;
    }
}
