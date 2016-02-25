/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import forum.dao.ForumDAOJpaImpl;
import forum.entity.Forum;
import java.util.Collection;

/**
 *
 * @author ajc
 */
public class ForumService {
    
    private ForumDAOJpaImpl dao = new ForumDAOJpaImpl();
    
    public void ajouter(Forum f){
        dao.ajouter(f);
    }
    public void supprimer(Forum f) {
       dao.supprimer(f);
    }
    
    public void supprimerTout() {
        dao.supprimerTout();
    }

    public void modifier(Forum f) {
       dao.modifier(f);
    }
    
    public Forum rechercherId(long id){
       return dao.rechercherId(id);
    }
    public Collection<Forum> rechercherTout(){
        return dao.rechercherTout();
    }
}
