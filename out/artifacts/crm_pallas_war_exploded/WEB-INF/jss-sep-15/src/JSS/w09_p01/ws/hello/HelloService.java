package JSS.w09_p01.ws.hello;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @author Cyril Kadomsky
 */

//@WebService(endpointInterface = "JSS.w09_p01.ws.hello.IHelloService", serviceName = "IHelloService",)
@WebService(name="IHelloService", serviceName = "HelloService", portName = "HelloPort", targetNamespace = "http://JSS.javajoy.net")
//@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class HelloService {
    @WebResult(name="helloString")
    @WebMethod(operationName = "sayHello")
    public String sayHelloWorldFrom(@WebParam(name="from") String from) {
           String result = "Hello, world, from " + from;
           System.out.println(result);
           return result;
    }

    @WebMethod(exclude = true)
    public int getID() {
        return 0;
    }
}
