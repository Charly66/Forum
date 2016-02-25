/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.dao;

import forum.entity.Message;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ajc
 */

@Repository
public class MessageDAOImpl implements MessageDAOInterface{
    
    private EntityManager em = Persistence.createEntityManagerFactory("ForumPU").createEntityManager();
    
    @Override
    public void ajouter(Message m){
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
    }
    
    @Override
    public void supprimer(Long id){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Message m WHERE m.id=" + id).executeUpdate();
        em.getTransaction().commit();
    }
    
    @Override
    public void modifier(Message m){
        em.getTransaction().begin();
        em.merge(m);
        em.getTransaction().commit();
    }
    
    @Override
    public Message rechercherId(Long id){
        return em.find(Message.class, id);
    }
    
    @Override
    public List<Message> rechercherTout(){
        return em.createQuery("SELECT m FROM Message m").getResultList();
    }
    
    @Override
    public void supprimerTout(){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Message m").executeUpdate();
        em.getTransaction().commit();
    }
}
