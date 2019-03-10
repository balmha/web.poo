/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencePackage;

import ar.edu.unnoba.poo2018.model.Compuesto;
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
public class CompuestoBean {

    @PersistenceContext(unitName = "webpoo")
    EntityManager em;
    
    public void create(Compuesto c) {
            em.persist(c);
        }

    public void Update(Compuesto c) {
        em.merge(c);
    }

    public void remove(Compuesto c) {
        em.remove(em.merge(c));
    }

    public Compuesto find(Object id) {
        return em.find(Compuesto.class, id);
    }
    
    public List getActividades(Long id) {
        Query query = em.createNativeQuery("SELECT * from Actividad a where a.id IN (select r.actividad_id from Responsables r where r.usuario_id=?) and a.id IN (select c.id from Actividades_Compuestas c)", Compuesto.class);
        query.setParameter(1, id);
        List<Compuesto> CompuestoList;
        try {
            CompuestoList = query.getResultList();
        } catch (Exception e) {
            CompuestoList = null;
        }
        return CompuestoList;
    }
}
