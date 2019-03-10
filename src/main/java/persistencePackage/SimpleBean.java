/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencePackage;

import ar.edu.unnoba.poo2018.model.Simple;
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
public class SimpleBean {

    @PersistenceContext(unitName = "webpoo")
    EntityManager em;
    
    public void create(Simple s) {
        em.persist(s);
    }

    public void Update(Simple s) {
        em.merge(s);
    }

    public void remove(Simple s) {
        em.remove(em.merge(s));
    }

    public Simple find(Object id) {
        return em.find(Simple.class, id);
    }
    
    public List getActividades(Long id) {
        Query query = em.createNativeQuery("SELECT * from Actividad a where a.id IN (select r.actividad_id from Responsables r where r.usuario_id=?) and a.id IN (select s.id from Actividades_Simples s)",Simple.class);
        query.setParameter(1, id);
        List<Simple> simpleList;
        try {
            simpleList = query.getResultList();
        } catch (Exception e) {
            simpleList = null;
        }
        return simpleList;
    }
    
    public List<Simple> getAll() {
        Query query = em.createNamedQuery("simple.getAllActividadSimple");
        return query.getResultList();
    }

}
