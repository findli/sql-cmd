package JSS.w09_p01.ws.hello;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Cyril Kadomsky
 */

@WebService
public interface IHelloService {
    String sayHelloWorldFrom(@WebParam(name="from") String from);
}
