

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AM
 */
@Entity
@Table(name = "moviegoer")
@XmlRootElement
@NamedQueries({
     @NamedQuery(name = "Moviegoer.checkLogin", query = "SELECT m FROM Moviegoer m where m.email= :email and m.password= :password")
    ,@NamedQuery(name = "Moviegoer.findAll", query = "SELECT m FROM Moviegoer m")
    , @NamedQuery(name = "Moviegoer.findByName", query = "SELECT m FROM Moviegoer m WHERE m.name = :name")
    , @NamedQuery(name = "Moviegoer.findBySurname", query = "SELECT m FROM Moviegoer m WHERE m.surname = :surname")
    , @NamedQuery(name = "Moviegoer.findByEmail", query = "SELECT m FROM Moviegoer m WHERE m.email = :email")
    , @NamedQuery(name = "Moviegoer.findByPassword", query = "SELECT m FROM Moviegoer m WHERE m.password = :password")
    , @NamedQuery(name = "Moviegoer.findByMoviegoerId", query = "SELECT m FROM Moviegoer m WHERE m.moviegoerId = :moviegoerId")})
public class Moviegoer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "surname")
    private String surname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "moviegoer_id")
    private Integer moviegoerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userEmail")
    private Collection<Ratings> ratingsCollection;

    public Moviegoer() {
    }

    public Moviegoer(Integer moviegoerId) {
        this.moviegoerId = moviegoerId;
    }

    public Moviegoer(Integer moviegoerId, String name, String surname, String email, String password) {
        this.moviegoerId = moviegoerId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getMoviegoerId() {
        return moviegoerId;
    }

    public void setMoviegoerId(Integer moviegoerId) {
        this.moviegoerId = moviegoerId;
    }

    @XmlTransient
    public Collection<Ratings> getRatingsCollection() {
        return ratingsCollection;
    }

    public void setRatingsCollection(Collection<Ratings> ratingsCollection) {
        this.ratingsCollection = ratingsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moviegoerId != null ? moviegoerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moviegoer)) {
            return false;
        }
        Moviegoer other = (Moviegoer) object;
        if ((this.moviegoerId == null && other.moviegoerId != null) || (this.moviegoerId != null && !this.moviegoerId.equals(other.moviegoerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "java_ds.Moviegoer[ moviegoerId=" + moviegoerId + " ]";
    }
    
}
