/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import forum.dao.MessageDAO;
import forum.entity.Message;
import java.util.Collection;


/**
 *
 * @author ajc
 */
public class MessageService {
    
    private MessageDAO dao = new MessageDAO();
    
    public void ajouter(Message m){
        dao.ajouter(m);
    }
    
    public void supprimer(Long id){
        dao.supprimer(id);
    }
    
    public void supprimerTout() {
        dao.supprimerTout();
    }
    
    public void modifier(Message m){
        dao.modifier(m);
    }
    
    public Message rechercherId(Long id){
        return dao.rechercherId(id);
    }
    
    public Collection<Message> rechercherTout(){
        return dao.rechercherTout();
    }
    
}
