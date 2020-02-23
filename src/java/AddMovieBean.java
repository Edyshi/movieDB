import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ManagedBean(name = "addMovieBean")
@SessionScoped
public class AddMovieBean {

    private Integer movieId;
    private String title;
    private Date releaseDate;
    private String director;
    private String rating;
    private String genre;

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("MovieDBPU");

    EntityManager em = emf.createEntityManager();

    public String newMovie() {

        em.getTransaction().begin();

        Movies m = new Movies();

        m.setReleaseDate(releaseDate);
        m.setDirector(director);
        m.setGenre(genre);
        m.setRating(rating);
        m.setTitle(title);
        m.setMovieId(movieId);

        em.persist(m);
        em.getTransaction().commit();

        releaseDate = null;
        director = null;
        genre = null;
        rating = null;
        title = null;
        movieId = null;

        return "/index.xhtml?faces-redirect=true";

    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
