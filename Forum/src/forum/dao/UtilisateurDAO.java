/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.dao;

import forum.entity.Utilisateur;
import java.util.List;

/**
 *
 * @author ajc
 */
public interface UtilisateurDAO {
    public void ajouter(Utilisateur u);
    public void supprimer(Long id);
    public void modifier(Utilisateur u);
    public Utilisateur rechercherId(Long id);
    public Utilisateur rechercherMail(String mail);
    public Utilisateur rechercherLogin(String login);
    public List<Utilisateur> rechercherTout();
    public void supprimerTout();
}
