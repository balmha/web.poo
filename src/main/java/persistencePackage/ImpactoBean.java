/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencePackage;

import ar.edu.unnoba.poo2018.model.Impacto;
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
    
    public float getImpactos(Long objetivo, Long user){
        Query query = em.createQuery("SELECT i.peso FROM Impacto i JOIN i.objetivo ob JOIN i.actividadSimple ac WHERE ob.nro=:objetivo and ac.id IN (SELECT s.id from Simple s join s.responsables r where r.id=:user)");
        Query query2 = em.createNativeQuery("Select i.peso from Impacto i join Actividades_Compuestas c join Responsables r where i.objetivo_id=? and r.usuario_id=? and c.id=r.actividad_id and i.actividad_id IN (select actividad_id from Actividades_Relacionadas ar where ar.actividad_compuesta_id=c.id)");
        query.setParameter("objetivo", objetivo);
        query.setParameter("user", user);
        query2.setParameter(1, objetivo);
        query2.setParameter(2, user);
        List<Integer> pesos;
        List<Integer> pesosCompuesta;
        float sumaSimples;
        float sumaCompuesta;
        try {
            pesosCompuesta=query2.getResultList();
            sumaCompuesta = this.sumaCompuestaFunc(pesosCompuesta);
        } catch (Exception e) {
            sumaCompuesta = 0;
        }
        try{
            pesos =query.getResultList();
            sumaSimples = this.sum(pesos,sumaCompuesta);
        }
        catch (Exception e) {
            sumaSimples = 0;
        }
        return sumaSimples;
    }
    
    public float sum(List<Integer> list,float sumaCompuesta) {
     int sum = 0;

     for (int i : list)
         sum = sum + i;
     
     float valorFinal=(sum+sumaCompuesta)/10;
     
     return valorFinal;
    }
    
    public float sumaCompuestaFunc(List<Integer> list) {
        int sum = 0;
        int j = 0;
        
        for (int i : list){
            j +=1;
            sum = sum + i;
        }
        
        float promedio = sum/j;
        
        return promedio;
    }

}
