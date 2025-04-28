package service.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("cities")
public class CityResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> findCities() {
        return List.of("London", "Toronto");
    }
}