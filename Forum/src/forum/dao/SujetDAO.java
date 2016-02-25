/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.dao;

import forum.entity.Sujet;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author ajc
 */
public class SujetDAO {
    
    private EntityManager em = Persistence.createEntityManagerFactory("ForumPU").createEntityManager();
    
    public void ajouter(Sujet s){
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
    }
    
    public void supprimer(Long id){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Sujet s WHERE s.id=" + id).executeUpdate();
        em.getTransaction().commit();
    }
    
    public void modifier(Sujet s){
        em.getTransaction().begin();
        em.merge(s);
        em.getTransaction().commit();
    }
    
    public Sujet rechercherId(Long id){
        return em.find(Sujet.class, id);
    }
    
    public Collection<Sujet> rechercherTout(){
        return em.createQuery("SELECT s FROM Sujet s").getResultList();
    }
    
    public void supprimerTout(){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Sujet s").executeUpdate();
        em.getTransaction().commit();
    }
}
