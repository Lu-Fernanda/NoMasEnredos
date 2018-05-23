
package genericdao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class SingletonConnection {
    private static EntityManager em ;
    private  static EntityManagerFactory emf;
    private static void initConnection(){
        
      emf= Persistence.createEntityManagerFactory("jpa");
    }
    
    public static EntityManager getConnection(){
       if(em == null ||!em.isOpen()){
                initConnection();
                em = emf.createEntityManager();
              em.getTransaction().begin();
           }
           return em;
    }
    
    public static void closeEmf() {
        if(emf.isOpen() || emf != null) {
            em.close();
            emf.close();
        }
        emf = null;
    } 
}
