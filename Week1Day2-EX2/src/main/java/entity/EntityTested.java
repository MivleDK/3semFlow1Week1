package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityTested {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        
        Customer c1 = new Customer("Bob", "Byggemand");
        Customer c2 = new Customer("Kirsten", "Hyttemejer");
        Customer c3 = new Customer("Stein", "Bagger");
        
        try{
            em.getTransaction().begin();
            em.persist(c1);
            em.persist(c2);
            em.persist(c3);
            em.getTransaction().commit();
        } finally{
            em.close();
        }
        
        
    }
    
}
