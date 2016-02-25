/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import forum.dao.ForumDAOImpl;
import forum.entity.Forum;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ajc
 */
@Service
public class ForumServiceImpl implements ForumServiceInterface{
    
    @Autowired
    private ForumDAOImpl dao;
    
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
    public List<Forum> rechercherTout(){
        return dao.rechercherTout();
    }
}
