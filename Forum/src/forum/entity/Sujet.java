/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 *
 * @author ajc
 */
@Entity
public class Sujet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titre;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreation;

    @ManyToOne
    @JoinColumn(name = "UTIL_ID")
    private Utilisateur createur;

    @ManyToOne
    @JoinColumn(name = "FORUM_ID")
    private Forum forum;

    @OneToMany(mappedBy = "sujet", cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    private List<Message> messagesSujet = new ArrayList<>();

    public Sujet() {
    }

    public Sujet(Long id, String titre, Date dateCreation) {
        this.id = id;
        this.titre = titre;
        this.dateCreation = dateCreation;
    }

    public Sujet(Long id, String titre, Date dateCreation, Utilisateur createur, Forum forum) {
        this.id = id;
        this.titre = titre;
        this.dateCreation = dateCreation;
        this.createur = createur;
        this.forum = forum;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

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
        if (!(object instanceof Sujet)) {
            return false;
        }
        Sujet other = (Sujet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "forum.entity.Sujet[ id=" + id + " ]";
    }

    public Utilisateur getCreateur() {
        return createur;
    }

    public void setCreateur(Utilisateur createur) {
        this.createur = createur;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public List<Message> getMessagesSujet() {
        return messagesSujet;
    }

    public void setMessagesSujet(List<Message> messagesSujet) {
        this.messagesSujet = messagesSujet;
    }

}
