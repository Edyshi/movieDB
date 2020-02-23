

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AM
 */
@Entity
@Table(name = "directors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Directors.findAll", query = "SELECT d FROM Directors d")
    , @NamedQuery(name = "Directors.findByDirectorId", query = "SELECT d FROM Directors d WHERE d.directorId = :directorId")
    , @NamedQuery(name = "Directors.findByName", query = "SELECT d FROM Directors d WHERE d.name = :name")
    , @NamedQuery(name = "Directors.findBySurname", query = "SELECT d FROM Directors d WHERE d.surname = :surname")})
public class Directors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "director_id")
    private Integer directorId;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "surname")
    private String surname;

    public Directors() {
    }

    public Directors(Integer directorId) {
        this.directorId = directorId;
    }

    public Integer getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Integer directorId) {
        this.directorId = directorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (directorId != null ? directorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Directors)) {
            return false;
        }
        Directors other = (Directors) object;
        if ((this.directorId == null && other.directorId != null) || (this.directorId != null && !this.directorId.equals(other.directorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "java_ds.Directors[ directorId=" + directorId + " ]";
    }
    
}
