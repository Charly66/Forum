/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */

@Service
public class DataService {

    @Autowired
    UtilisateurService utilisateur;
    ForumServiceImpl forum;
    MessageServiceImpl message;
    SujetServiceImpl sujet;

    public void deleteAll() {

        utilisateur.supprimerTout();
        forum.supprimerTout();
        message.supprimerTout();
        sujet.supprimerTout();
    }

}
