package JSS.w10.rs;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("rest")
public class ConfigResource extends ResourceConfig {

    public ConfigResource() {
        packages("JSS.w10.rs");
    }
}
