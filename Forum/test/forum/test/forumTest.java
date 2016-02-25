/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.test;

import forum.entity.Message;
import forum.service.DataService;
import forum.service.ForumServiceImpl;
import forum.service.MessageServiceImpl;
import forum.service.SujetServiceImpl;
import forum.service.UtilisateurServiceImpl;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author ajc
 */

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "file:/C:\\Users\\admin\\Desktop\\Projets\\Forum\\Forum\\application-context.xml")
@ContextConfiguration(locations = "file:/C:\\Users\\ajc\\Documents\\NetBeansProjects\\Forum\\Forum\\application-context.xml")


public class forumTest {
    
    @Autowired
    private MessageServiceImpl messageService;
    @Autowired
    private SujetServiceImpl sujetService;
    @Autowired
    private ForumServiceImpl forumService;
    @Autowired
    private UtilisateurServiceImpl utilisateurService;
    @Autowired
    private DataService dataService;
    
    
    @Test
    public void ajouterMessage(){
        messageService.ajouter(new Message(1L, "titre", new Date(), "contenu"));
        System.out.println(messageService.rechercherTout());
    }
}
