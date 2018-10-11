/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencePackage;

import ar.edu.unnoba.poo2018.model.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Balma
 */
@Stateless
public class UsuarioBean {

    @PersistenceContext(unitName = "webpoo")
    EntityManager em;

    public void create(Usuario user) {
        em.persist(user);
    }

    public void Update(Usuario user) {
        em.merge(user);
    }

    public void remove(Usuario user) {
        em.remove(em.merge(user));
    }

    public Usuario find(Object id) {
        return em.find(Usuario.class, id);
    }
}
