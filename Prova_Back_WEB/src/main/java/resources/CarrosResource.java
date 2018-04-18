package resources;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Carro;
import persistence.CarroDao;

@Path("carros")
public class CarrosResource {

    @Context
    private UriInfo context;

    public CarrosResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Carro> getJson1() {
        return CarroDao.listar();
    }
    
    @GET
    @Path( "/modelo/{modelo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Carro getJson2( @PathParam( "modelo" ) String modelo ) {
        return (Carro) CarroDao.listar( modelo );
    }


}
