/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencePackage;

import ar.edu.unnoba.poo2018.model.Convocatoria;
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
public class ConvocatoriaBean {

    @PersistenceContext(unitName = "webpoo")
    EntityManager em;

    public void create(Convocatoria c) {
        em.persist(c);
    }

    public void Update(Convocatoria c) {
        em.merge(c);
    }

    public void remove(Convocatoria c) {
        em.remove(em.merge(c));
    }

    public Convocatoria find(Object nro) {
        return em.find(Convocatoria.class, nro);
    }

    public List getConvocatorias() {
        Query query = em.createQuery("SELECT c FROM Convocatoria c");
        List<Convocatoria> convocatoriasList;
        try {
            convocatoriasList = query.getResultList();
        } catch (Exception e) {
            convocatoriasList = null;
        }
        return convocatoriasList;
    }
}
