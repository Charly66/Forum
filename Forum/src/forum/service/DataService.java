/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

/**
 *
 * @author admin
 */
public class DataService {
    
    public void deleteAll(){
       UtilisateurService utilisateur = new UtilisateurService();
       ForumServiceImpl forum = new ForumServiceImpl();
       MessageService message = new MessageService();
       SujetService sujet = new SujetService();
       
       utilisateur.supprimerTout();
       forum.supprimerTout();
       message.supprimerTout();
       sujet.supprimerTout();
    }
    
}
