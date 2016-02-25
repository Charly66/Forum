/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import forum.dao.UtilisateurDAOImpl;
import forum.entity.Utilisateur;
import forum.exception.DejaInscritException;
import forum.exception.LoginInconnuException;
import forum.exception.PasswordException;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ajc
 */
@Service
public class UtilisateurServiceImpl implements UtilisateurServiceInterface{

    @Autowired
    private UtilisateurDAOImpl dao;

    public void inscription(Utilisateur u) throws DejaInscritException {
        if (rechercherLogin(u.getLogin()) != null) {
            throw new DejaInscritException();
        }
        if (rechercherMail(u.getEmail()) != null) {
            throw new DejaInscritException();
        }
        ajouter(u);
        new MailService().mail(u.getEmail(), "Inscription", "Bienvenue !!!");
        validationInscription(u.getEmail());

    }

    public void validationInscription(String mail) {
        Utilisateur u = rechercherMail(mail);
        u.setValidation(true);
        modifier(u);
    }
    
    public void login(String login, String password) throws PasswordException, LoginInconnuException {
        Utilisateur u = rechercherLogin(login);
        if (u == null) {
            throw new LoginInconnuException();
        }
        System.out.println(u.getPassword() +" "+password);
        if (u.getPassword().equals(password)){
            System.out.println("Connection Login effectuée");
        }
        else{
            throw new PasswordException();
        }
    }

    public void ajouter(Utilisateur u) {
        dao.ajouter(u);
    }

    public void supprimer(Long id) {
        dao.supprimer(id);
    }
    
    public void supprimerTout() {
        dao.supprimerTout();
    }

    public void modifier(Utilisateur u) {
        dao.modifier(u);
    }

    public Utilisateur rechercherId(Long id) {
        return dao.rechercherId(id);
    }

    public List<Utilisateur> rechercherTout() {
        return dao.rechercherTout();
    }

    public Utilisateur rechercherMail(String mail) {
        return dao.rechercherMail(mail);
    }
    
    public Utilisateur rechercherLogin(String login) {
        return dao.rechercherLogin(login);
    }

}
