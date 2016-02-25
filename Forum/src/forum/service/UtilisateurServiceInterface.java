/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import forum.entity.Utilisateur;
import forum.exception.DejaInscritException;
import forum.exception.LoginInconnuException;
import forum.exception.PasswordException;
import java.util.List;

/**
 *
 * @author ajc
 */
public interface UtilisateurServiceInterface {
    public void inscription(Utilisateur u) throws DejaInscritException;
    public void validationInscription(String mail);
    public void login(String login, String password) throws PasswordException, LoginInconnuException;
    public void ajouter(Utilisateur u);
    public void supprimer(Long id);
    public void supprimerTout();
    public void modifier(Utilisateur u);
    public Utilisateur rechercherId(Long id);
    public List<Utilisateur> rechercherTout();
    public Utilisateur rechercherMail(String mail);
    public Utilisateur rechercherLogin(String login);
}
