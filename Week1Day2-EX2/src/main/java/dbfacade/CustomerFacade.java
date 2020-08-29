package dbfacade;

import entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class CustomerFacade {

    private static EntityManagerFactory emf;
    private static CustomerFacade instance;

    public CustomerFacade() {
    }

    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        CustomerFacade facade = CustomerFacade.getCustomerFacade(emf);
        Customer c1 = facade.addCustomer("Bob", "Byggemand");
        Customer c2 = facade.addCustomer("Kirsten", "Hyttemejer");
        Customer c3 = facade.addCustomer("Kirsten", "Hansen");
        Customer c4 = facade.addCustomer("Stein", "Bagger");

        System.out.println("\nFind customer by ID");
        System.out.println("Customer 2 " + facade.findByID(c2.getId()).getFirstName());

        System.out.println("\n Find by lastname \"Hansen\"");
        System.out.println(facade.findByLastName("Hansen"));

        System.out.println("\n Get number of customers: ");
        System.out.println("Number of customer: " + facade.getNumberOfCustomers());
    }

    public Customer findByID(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Customer customer = em.find(Customer.class, id);
            return customer;
        } finally {
            em.close();
        }
    }

    public String findByLastName(String lastName) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT c.lastName FROM Customer c WHERE c.lastName = :lastName");
            query.setParameter("lastName", lastName);
            String customer = (String) query.getSingleResult();
            return customer;
        } finally {
            em.close();
        }
    }

    public List<Customer> allCustomer() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query = em.createQuery("SELECT Customer c from Customer c", Customer.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Long getNumberOfCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT COUNT(c) FROM Customer c");
            return (Long) query.getSingleResult();
        } finally {
            em.close();
        }
    }

    public Customer addCustomer(String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
            return customer;
        } finally {
            em.close();
        }
    }

//List<Customer> findByLastName(String name);
}
