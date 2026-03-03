package resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/dashboard")
public class DashboardResource {

    @GET
    @Path("admin")
    public String getInfo() {
        return "Panel de administracion";
    }

}
