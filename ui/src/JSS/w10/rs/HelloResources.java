package JSS.w10.rs;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/helloworld")
public class HelloResources {

    @GET
    @Produces("text/plain")
    public String getTextMessage() {

        return "Hello World plain";
    }

    @POST
    public String getPostMessage() {

        return "Hello World POST";
    }
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtmlMessage() {

        return "Hello World 123";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJsonMessage() {
//todo  impl
        return "json";
    }

    public static void main(String[] args) throws IOException {
        // or cxf-servlet.xml
        // create service with CXF
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        sf.setResourceClasses(HelloResources.class);
//        sf.setAddress("http://localhost:8080/servlets/resources");
        sf.setAddress("http://localhost/rs");
        Server server = sf.create();

        System.out.println("JAX-RS Server started");
        System.out.println("Visit: http://localhost/rs/helloworld);");
        System.out.println("Hit return to stop....");
        System.in.read();
        System.out.println("Stopping server");

        // stop service with CXF
        server.stop();

        System.out.println("Server stopped");
    }
}
