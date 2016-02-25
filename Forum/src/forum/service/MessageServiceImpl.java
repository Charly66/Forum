/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import forum.dao.MessageDAOImpl;
import forum.entity.Message;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author ajc
 */
@Service
public class MessageServiceImpl implements MessageServiceInterface{
    
    @Autowired
    private MessageDAOImpl dao;
    
    @Override
    public void ajouter(Message m){
        dao.ajouter(m);
    }
    
    @Override
    public void supprimer(Long id){
        dao.supprimer(id);
    }
    
    @Override
    public void supprimerTout() {
        dao.supprimerTout();
    }
    
    @Override
    public void modifier(Message m){
        dao.modifier(m);
    }
    
    @Override
    public Message rechercherId(Long id){
        return dao.rechercherId(id);
    }
    
    @Override
    public List<Message> rechercherTout(){
        return dao.rechercherTout();
    }
    
}
