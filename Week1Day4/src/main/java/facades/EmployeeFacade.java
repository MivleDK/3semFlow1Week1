package facades;

import dto.EmployeeDTO;
import entities.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class EmployeeFacade {

    private static EmployeeFacade instance;
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public EmployeeFacade() {
    }

    public static EmployeeFacade getEmployeeFacade(EntityManagerFactory _emf) {

        if (instance == null) {
            emf = _emf;
            instance = new EmployeeFacade();
        }
        return instance;
    }

    
//  BLIVER IKKE BRUGT FORDI JEG IKKE KAN FINDE UD AF AT SENDE PARAMETRE FRA REST ENDPOINT
    
//    public Employee getEmployeeById(int id) {
//        EntityManager em = emf.createEntityManager();
//        try {
//            Employee employee = em.find(Employee.class, id);
//            return employee;
//        } finally {
//            em.close();
//        }
//    }

//  BLIVER IKKE BRUGT FORDI JEG IKKE KAN FINDE UD AF AT SENDE PARAMETRE FRA REST ENDPOINT
    
//    public void getEmployeeByName(String name) {
//        EntityManager em = emf.createEntityManager();
//        try {
//            Query query = em.createQuery("SELECT e FROM Employee e WHERE e.name= :name");
//            query.setParameter("name", name);
//            String result = (String) query.getSingleResult();
//            System.out.println(result);
//        } finally {
//            em.close();
//        }
//    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeDTO> edtoList = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        TypedQuery<Employee> tq = em.createNamedQuery("Employee.findAll", Employee.class);
        List<Employee> employees = tq.getResultList();
        employees.stream().forEach(p -> {
            edtoList.add(new EmployeeDTO(p));
        });
        return edtoList;
    }

    public List getEmployeeWithHighestSalary() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT e FROM Employee e WHERE e.salary = (SELECT MAX(e.salary) FROM Employee e)");
            List<Employee> result = query.getResultList();
            return result;
        } finally {
            em.close();
        }
    }

    public Employee createEmployee(String name, String adress, double salary) {
        Employee employee = new Employee(name, adress, salary);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();
            return employee;
        } finally {
            em.close();
        }
    }

}
