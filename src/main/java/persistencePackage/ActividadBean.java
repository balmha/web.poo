    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencePackage;

import ar.edu.unnoba.poo2018.model.Actividad;
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
public class ActividadBean {

    @PersistenceContext(unitName = "webpoo")
    EntityManager em;
    
    public void create(Actividad a) {
        em.persist(a);
    }

    public void Update(Actividad a) {
        em.merge(a);
    }

    public void remove(Actividad a) {
        em.remove(em.merge(a));
    }

    public Actividad find(Object id) {
        return em.find(Actividad.class, id);
    }
    
    public List getActividades(Long id) {
        Query query = em.createQuery("SELECT a FROM Actividad a");
        Query query2 = em.createNativeQuery("SELECT * from Actividad s where s.id IN (select r.actividad_id from Responsables r where r.usuario_id=?)",Actividad.class);
        query2.setParameter(1, id);
        List<Actividad> actividadList;
        try {
            actividadList =query2.getResultList();
            System.out.println(actividadList);
        } catch (Exception e) {
            actividadList = null;
        }
        return actividadList;
    }
    
}
