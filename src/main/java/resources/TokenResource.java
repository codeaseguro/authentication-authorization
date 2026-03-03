package resources;


import io.quarkus.oidc.IdToken;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/tokens")
public class TokenResource {

    @Inject
    @IdToken
    JsonWebToken idToken;

    @GET
    @Produces("text/html")
    public String getTokens() {
        StringBuilder response = new StringBuilder()
                .append("<html><body><ul>");

        String sub = idToken.getSubject();
        String name = (String) idToken.getClaim("name");
        String email = (String) idToken.getClaim("email");

        response.append("<li>sub: ").append(sub).append("</li>");
        response.append("<li>name: ").append(name).append("</li>");
        response.append("<li>email: ").append(email).append("</li>");
        response.append("<li>issuer: ").append(idToken.getIssuer()).append("</li>");
        response.append("<li>claim names: ").append(idToken.getClaimNames()).append("</li>");

        response.append("</ul></body></html>");
        return response.toString();
    }

}
