/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencePackage;

import ar.edu.unnoba.poo2018.model.Impacto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Balma
 */
@Stateless
public class ImpactoBean {

    @PersistenceContext(unitName = "webpoo")
    EntityManager em;
    
    public void create(Impacto i) {
        em.persist(i);
    }

    public void Update(Impacto i) {
        em.merge(i);
    }

    public void remove(Impacto i) {
        em.remove(em.merge(i));
    }

    public Impacto find(Object nro) {
        return em.find(Impacto.class, nro);
    }

}
