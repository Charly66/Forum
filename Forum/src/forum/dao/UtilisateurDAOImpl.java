/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.dao;


import forum.entity.Utilisateur;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ajc
 */
@Repository
public class UtilisateurDAOImpl implements UtilisateurDAO{
    
    private EntityManager em = Persistence.createEntityManagerFactory("ForumPU").createEntityManager();

    public void ajouter(Utilisateur u){
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
    }
    
    public void supprimer(Long id){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Utilisateur u WHERE u.id=" + id).executeUpdate();
        em.getTransaction().commit();
    }
    
    public void modifier(Utilisateur u){
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
    }
    
    public Utilisateur rechercherId(Long id){
        return em.find(Utilisateur.class, id);
    }
    
    public Utilisateur rechercherMail(String mail){
        Utilisateur u;
        try{
        u =  (Utilisateur) em.createQuery("SELECT u FROM Utilisateur u WHERE u.email='"+mail+"'").getSingleResult();
        } catch(Exception e){
            u = null;
            System.out.println("Le mail n'existe pas encore");
        }
        return u;
    }
    
    public Utilisateur rechercherLogin(String login){
        Utilisateur u;
        try{
        u =  (Utilisateur) em.createQuery("SELECT u FROM Utilisateur u WHERE u.login='"+login+"'").getSingleResult();
        } catch(Exception e){
            u = null;
            System.out.println("Le login n'existe pas encore");
        }
        return u;
    }
    
    public List<Utilisateur> rechercherTout(){
        return em.createQuery("SELECT u FROM Utilisateur u").getResultList();
    }
    
    public void supprimerTout(){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Utilisateur u").executeUpdate();
        em.getTransaction().commit();
    }
    
}
