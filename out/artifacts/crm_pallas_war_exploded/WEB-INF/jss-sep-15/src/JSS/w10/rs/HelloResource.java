package JSS.w10.rs;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.IOException;

// The Java class will be hosted at the URI path "/helloworld"
@Path("/helloworld")
public class HelloResource {

    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public String getTextMessage() {

        return "Hello World";
    }

    @GET
    @Produces("text/html")
    public String getHtmlMessage() {

        return "Hello HTML";
    }


    public static void main(String[] args) throws IOException {

        // Create service with CXF
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        sf.setResourceClasses(HelloResource.class);
        sf.setAddress("http://localhost/rs");
        Server server = sf.create();

        // Create service with Jersea
//        HttpServer server = HttpServerFactory.create("http://localhost:8080/servlets/resources");
//        server.start();

        System.out.println("JAX-RS Server started");
        System.out.println("Visit: http://localhost/rs/helloworld");
        System.out.println("Hit return to stop...");
        System.in.read();
        System.out.println("Stopping server");


        // Stop service with CXF
        server.stop();

        // Stop service with Jersea
//        server.stop(0);

        System.out.println("Server stopped");

    }
}
