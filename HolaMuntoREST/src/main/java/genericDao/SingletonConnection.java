
package genericdao;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class SingletonConnection {
        
    private static EntityManager em ;
    private  static EntityManagerFactory emf;
    private static void initConnection(){
      startOperation();
    }

    public static EntityManager getConnection() {
        if (em == null) {

            initConnection();
            em = emf.createEntityManager();
            em.getTransaction().begin();
        }
        return em;
    }

    public static void closeEmf() {
        if (emf.isOpen() || emf != null) {
            em.close();
            emf.close();
        }
        emf = null;
    }
    
    protected static void startOperation() { 
        URI dbUri = null;
        try {
            dbUri = new URI(System.getenv("DATABASE_URL")); 
            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

            Map<String, String> properties = new HashMap<String, String>();
            properties.put("javax.persistence.jdbc.url", dbUrl);
            properties.put("javax.persistence.jdbc.user", username );
            properties.put("javax.persistence.jdbc.password", password );
            properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
            properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            emf = Persistence.createEntityManagerFactory("jpa",properties);
            em = emf.createEntityManager();
        } catch (URISyntaxException ex) {
            Logger.getLogger(SingletonConnection.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
}
