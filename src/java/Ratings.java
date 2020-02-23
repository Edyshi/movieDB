

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "ratings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ratings.findAll", query = "SELECT r FROM Ratings r")
    , @NamedQuery(name = "Ratings.findByRating", query = "SELECT r FROM Ratings r WHERE r.rating = :rating")
    , @NamedQuery(name = "Ratings.findByRatingId", query = "SELECT r FROM Ratings r WHERE r.ratingId = :ratingId")})
public class Ratings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rating")
    private float rating;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rating_id")
    private Integer ratingId;
  
    @JoinColumn(name = "user_email", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private Moviegoer userEmail;
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    @ManyToOne(optional = false)
    private Movies movieId;

    public Ratings() {
    }

    public Ratings(Integer ratingId) {
        this.ratingId = ratingId;
    }

    public Ratings(Integer ratingId, float rating) {
        this.ratingId = ratingId;
        this.rating = rating;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Integer getRatingId() {
        return ratingId;
    }

    public void setRatingId(Integer ratingId) {
        this.ratingId = ratingId;
    }

    public Moviegoer getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(Moviegoer userEmail) {
        this.userEmail = userEmail;
    }

    public Movies getMovieId() {
        return movieId;
    }

    public void setMovieId(Movies movieId) {
        this.movieId = movieId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ratingId != null ? ratingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ratings)) {
            return false;
        }
        Ratings other = (Ratings) object;
        if ((this.ratingId == null && other.ratingId != null) || (this.ratingId != null && !this.ratingId.equals(other.ratingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "java_ds.Ratings[ ratingId=" + ratingId + " ]";
    }
    
}
