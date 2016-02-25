/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import forum.dao.SujetDAOImpl;
import forum.entity.Sujet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author ajc
 */

@Service
public class SujetServiceImpl implements SujetServiceInterface{
    
    @Autowired
    private SujetDAOImpl dao;
    
    @Override
    public void ajouter(Sujet s){
        dao.ajouter(s);
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
    public void modifier(Sujet s){
        dao.modifier(s);
    }
    
    @Override
    public Sujet rechercherId(Long id){
        return dao.rechercherId(id);
    }
    
    @Override
    public List<Sujet> rechercherTout(){
        return dao.rechercherTout();
    }
    
}
