/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author ajc
 */
@Service
public class MailService implements MailServiceInterface{
    
    private String emeteur = "Forum@forum.com";
    private String dest;
    private String titre;
    private String message; 
    
    
    public void mail(String dest, String titre, String message){
        System.out.println("Mail envoyé");
        
    }
    
}
