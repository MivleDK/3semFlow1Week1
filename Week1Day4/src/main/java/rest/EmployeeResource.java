package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Employee;
import facades.EmployeeFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("employee")
public class EmployeeResource {

    @Context
    private UriInfo context;

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private EmployeeFacade employeeFacade = new EmployeeFacade();

    public EmployeeResource() {
    }

    /**
     * Retrieves representation of an instance of rest.EmployeeResource
     *
     * @return an instance of java.lang.String
     */
    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEmployees() {
        return Response.ok().entity(gson.toJson(employeeFacade.getAllEmployees())).build();
    }
    
    @Path("/highestpaid")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHighestSalary() {
        return Response.ok().entity(gson.toJson(employeeFacade.getEmployeeWithHighestSalary())).build();
    }    

    //BURDE NOK GÅ TIL FACADEN. HVORDAN SENDER MAN PARAMETER MED DERIND?
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmployeeId(@PathParam("id") int id) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE e.id=:id", Employee.class);
            query.setParameter("id", id);
            List<Employee> employee = query.getResultList();
            return new Gson().toJson(employee);
        } finally {
            em.close();
        }
    }
    
    //BURDE NOK GÅ TIL FACADEN. HVORDAN SENDER MAN PARAMETER MED DERIND?
    @Path("/name/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmployeeName(@PathParam("name") String name) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE e.name=:name", Employee.class);
            String tName = name;
            query.setParameter("name", tName);
            List<Employee> employee = query.getResultList();
            return new Gson().toJson(employee);
        } finally {
            em.close();
        }
    }    
    
    /**
     * PUT method for updating or creating an instance of EmployeeResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
