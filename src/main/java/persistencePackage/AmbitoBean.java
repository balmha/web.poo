/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencePackage;

import ar.edu.unnoba.poo2018.model.Ambito;
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
public class AmbitoBean {

    @PersistenceContext(unitName = "webpoo")
    EntityManager em;

    public void create(Ambito ambito) {
        em.persist(ambito);
    }

    public void Update(Ambito ambito) {
        em.merge(ambito);
    }

    public void remove(Ambito ambito) {
        em.remove(em.merge(ambito));
    }

    public Ambito find(Object nro) {
        return em.find(Ambito.class, nro);
    }

    public List getAmbitos() {
        Query query = em.createQuery("SELECT a FROM Ambito a");
        List<Ambito> ambitosList;
        try {
            ambitosList = query.getResultList();
        } catch (Exception e) {
            ambitosList = null;
        }
        return ambitosList;
    }
}
