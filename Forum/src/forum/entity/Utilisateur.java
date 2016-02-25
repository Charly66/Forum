/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 *
 * @author ajc
 */
@Entity
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String password;
    private Boolean validation = false;
    
    @OneToOne
    @JoinColumn(name = "INSEE_ID")
    private Insee insee;

    @OneToMany(mappedBy = "createur", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @CascadeOnDelete
    private List<Forum> forumsCrees = new ArrayList<Forum>();

    @OneToMany(mappedBy = "createur", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @CascadeOnDelete
    private List<Sujet> sujetsCrees = new ArrayList<Sujet>();

    @OneToMany(mappedBy = "createur", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @CascadeOnDelete
    private List<Message> messagesCrees = new ArrayList<Message>();

    public Boolean getValidation() {
        return validation;
    }

    public void setValidation(Boolean validation) {
        this.validation = validation;
    }

    public Utilisateur() {
    }

    public Utilisateur(Long id, String login, String password, String email) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    private String email;

    public List<Forum> getForumsCrees() {
        return forumsCrees;
    }

    public void setForumsCrees(List<Forum> forumsCrees) {
        this.forumsCrees = forumsCrees;
    }

    public List<Sujet> getSujetsCrees() {
        return sujetsCrees;
    }

    public void setSujetsCrees(List<Sujet> sujetsCrees) {
        this.sujetsCrees = sujetsCrees;
    }

    public List<Message> getMessagesCrees() {
        return messagesCrees;
    }

    public void setMessagesCrees(List<Message> messagesCrees) {
        this.messagesCrees = messagesCrees;
    }

    public Insee getInsee() {
        return insee;
    }

    public void setInsee(Insee insee) {
        this.insee = insee;
    }

    

    private enum typeUtil {
        MODERATEUR,
        ADMIN,
        UTILISATEUR
    };

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "forum.entity.Utilisateur[ id=" + id + " ]";
    }

}
