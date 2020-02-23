
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private String email;
    private String password;

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

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("MovieDBPU");

    EntityManager em = emf.createEntityManager();

    TypedQuery<Moviegoer> findMoviegoer = (TypedQuery<Moviegoer>) em.createNamedQuery("Moviegoer.checkLogin", Moviegoer.class)
            .setParameter("email", email).setParameter("password", password); // query to find a Moviegoer with these credentials
    

    public String tryLogin() {  
        List<Moviegoer> l = findMoviegoer.getResultList();

        if (l == null || l.isEmpty()) {  //authetication nuk kuoton eshte user i regjistruar apo jo
                                         // Logini i userit: Email: john@pers.com Pass: john

            return "/index.xhtml?faces-redirect=true"; //nqs useri nuk ekziston ne DB duhe te behet redirect ne index.xhtml

        } else {
            return "/add_movie?faces-redirect=true"; // nqs ekziston duhet te behet redirect tek add_movie
        }
    }

}
