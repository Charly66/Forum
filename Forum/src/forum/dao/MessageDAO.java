/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.dao;

import forum.entity.Message;
import forum.entity.Sujet;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author ajc
 */
public class MessageDAO {
    
    private EntityManager em = Persistence.createEntityManagerFactory("ForumPU").createEntityManager();
    
    public void ajouter(Message m){
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
    }
    
    public void supprimer(Long id){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Message m WHERE m.id=" + id).executeUpdate();
        em.getTransaction().commit();
    }
    
    public void modifier(Message m){
        em.getTransaction().begin();
        em.merge(m);
        em.getTransaction().commit();
    }
    
    public Message rechercherId(Long id){
        return em.find(Message.class, id);
    }
    
    public Collection<Message> rechercherTout(){
        return em.createQuery("SELECT m FROM Message m").getResultList();
    }
    
    public void supprimerTout(){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Message m").executeUpdate();
        em.getTransaction().commit();
    }
}
