/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import forum.dao.SujetDAO;
import forum.entity.Sujet;
import java.util.Collection;


/**
 *
 * @author ajc
 */
public class SujetService {
    
    private SujetDAO dao = new SujetDAO();
    
    public void ajouter(Sujet s){
        dao.ajouter(s);
    }
    
    public void supprimer(Long id){
        dao.supprimer(id);
    }
    
    public void supprimerTout() {
        dao.supprimerTout();
    }
    
    public void modifier(Sujet s){
        dao.modifier(s);
    }
    
    public Sujet rechercherId(Long id){
        return dao.rechercherId(id);
    }
    
    public Collection<Sujet> rechercherTout(){
        return dao.rechercherTout();
    }
    
}
