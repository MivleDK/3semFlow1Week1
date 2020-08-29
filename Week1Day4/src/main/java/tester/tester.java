package tester;

import entities.Employee;
import facades.EmployeeFacade;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class tester {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public static void main(String[] args) {

        Employee e1 = new Employee("Bob", "Bobbevej 2", 25000);
        Employee e2 = new Employee("Kirsten", "Kistevej 12", 29500);
        Employee e3 = new Employee("Søren", "Rygevej 1", 82);
        Employee e4 = new Employee("Gan", "dalfevej 9", 55000);
        Employee e5 = new Employee("Stein", "Baggervej", 150000);

        EmployeeFacade emplF = new EmployeeFacade();
        emplF.createEmployee("Kim", "Jyllingevej 2", 85000);
        
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(e1);
            em.persist(e2);
            em.persist(e3);
            em.persist(e4);
            em.persist(e5);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
