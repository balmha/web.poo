/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencePackage;

import ar.edu.unnoba.poo2018.model.Objetivo;
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
public class ObjetivoBean {

    @PersistenceContext(unitName = "webpoo")
    EntityManager em;

    public void create(Objetivo objetivo) {
        em.persist(objetivo);
    }

    public void Update(Objetivo objetivo) {
        em.merge(objetivo);
    }

    public void remove(Objetivo objetivo) {
        em.remove(em.merge(objetivo));
    }

    public Objetivo find(Object nro) {
        return em.find(Objetivo.class, nro);
    }

    public List getObjetivos() {
        Query query = em.createQuery("SELECT o FROM Objetivo o");
        List<Objetivo> objetivosList;
        try {
            objetivosList = query.getResultList();
        } catch (Exception e) {
            objetivosList = null;
        }
        return objetivosList;
    }
}
