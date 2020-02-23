
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

@ManagedBean(name = "listMoviesBean")
@SessionScoped
public class ListMoviesBean {

    String title;
    String director;
    String genre;
    String max;
    String min;

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("MovieDBPU");

    EntityManager em = emf.createEntityManager();

    TypedQuery<Movies> findallMovies = em.createNamedQuery("Movies.findAll", Movies.class);

    List<Movies> movie_list = findallMovies.getResultList();

    public void reset() {
        TypedQuery<Movies> findallMovies = em.createNamedQuery("Movies.findAll", Movies.class);

        movie_list = findallMovies.getResultList();

    }

    public List<Movies> getMovies() {
        return movie_list;
    }

    public void byPattern() {

        TypedQuery<Movies> findByTitle = em.createQuery("select m from Movies m where m.title LIKE CONCAT('%',:title,'%')", Movies.class).setParameter("title", title);

        movie_list = findByTitle.getResultList();

        title = null;
    }

    public void byDirector() {

        TypedQuery<Movies> findByDirector = em.createQuery("select m from Movies m where m.director LIKE CONCAT('%',:director,'%')", Movies.class).setParameter("director", director);

        movie_list = findByDirector.getResultList();

        director = null;

    }

    public void byGenre() {

        TypedQuery<Movies> findByGenre = em.createQuery("select m from Movies m where m.genre LIKE CONCAT('%',:genre,'%')", Movies.class).setParameter("genre", genre);

        movie_list = findByGenre.getResultList();

        genre = null;

    }

    public void avgRating() {

        TypedQuery<Movies> findByavg = em.createQuery("select m from Movies m where m.rating BETWEEN :min and :max", Movies.class).
                setParameter("max", max).setParameter("min", min);

        movie_list = findByavg.getResultList();
    }

    public void top10() {

        TypedQuery<Movies> findBytop10 = em.createQuery("select m from Movies m ORDER BY m.rating asc limit 10", Movies.class);

        movie_list = findBytop10.getResultList();

    }

}
