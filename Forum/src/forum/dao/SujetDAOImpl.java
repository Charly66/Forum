/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.dao;

import forum.entity.Sujet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ajc
 */

@Repository
public class SujetDAOImpl implements SujetDAOInterface{
    
    private EntityManager em = Persistence.createEntityManagerFactory("ForumPU").createEntityManager();
    
    @Override
    public void ajouter(Sujet s){
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
    }
    
    @Override
    public void supprimer(Long id){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Sujet s WHERE s.id=" + id).executeUpdate();
        em.getTransaction().commit();
    }
    
    @Override
    public void modifier(Sujet s){
        em.getTransaction().begin();
        em.merge(s);
        em.getTransaction().commit();
    }
    
    @Override
    public Sujet rechercherId(Long id){
        return em.find(Sujet.class, id);
    }
    
    @Override
    public List<Sujet> rechercherTout(){
        return em.createQuery("SELECT s FROM Sujet s").getResultList();
    }
    
    @Override
    public void supprimerTout(){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Sujet s").executeUpdate();
        em.getTransaction().commit();
    }
}
