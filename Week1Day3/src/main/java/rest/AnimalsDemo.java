package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.AnimalNoDB;

@Path("animals")
public class AnimalsDemo {

    private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    @Context
    private UriInfo context;

    public AnimalsDemo() {
    }

    /**
     * Retrieves representation of an instance of rest.AnimalsDemo
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getJson() {
        return "Vuf";
    }
    
    @Path("/animal_list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAnimalList() {
        return "[\"Dog\", [\"Cat\", [\"Mouse\", [\"Bird\",]";
    }    
    
    @Path("/animal")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String newAnimalNoDB() {
        AnimalNoDB a = new AnimalNoDB("Hare", "Ha ha hare!");
        String jsonString = GSON.toJson(a);
        return jsonString;
    }        

    /**
     * PUT method for updating or creating an instance of AnimalsDemo
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
