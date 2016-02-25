/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.dao;

import forum.entity.Forum;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author ajc
 */
public class ForumDAO {
    private EntityManager em = Persistence.createEntityManagerFactory("ForumPU").createEntityManager();
    
    public void ajouter(Forum f){
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
    }
    public void supprimer(Forum f) {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Forum f WHERE f.id=" + f.getId()).executeUpdate();
        em.getTransaction().commit();
    }

    public void modifier(Forum f) {
        em.getTransaction().begin();
        em.merge(f);
        em.getTransaction().commit();
    }
    
    public Forum rechercherId(long id){
        //return (Forum) em.createQuery("Select f FROM Forum f WHERE f.id="+id);
       return em.find(Forum.class, id);
    }
    
    public Collection<Forum> rechercherTout(){
        return em.createQuery("Select f FROM Forum f").getResultList();
    }
    
    public void supprimerTout(){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Forum f ").executeUpdate();
        em.getTransaction().commit();
    }
    
    
}
