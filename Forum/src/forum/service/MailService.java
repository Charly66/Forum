/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

/**
 *
 * @author ajc
 */
public class MailService {
    
    private String emeteur = "Forum@forum.com";
    private String dest;
    private String titre;
    private String message; 
    
    
    public void mail(String dest, String titre, String message){
        System.out.println("Mail envoyé");
        
    }
    
}
