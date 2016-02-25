/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.dao;

import forum.entity.Forum;
import java.util.List;

/**
 *
 * @author ajc
 */
public interface ForumDAO {
    public void ajouter(Forum f);
    public void supprimer(Forum f);
    public void modifier(Forum f);
    public Forum rechercherId(long id);
    public List<Forum> rechercherTout();
    public void supprimerTout();
    
}
