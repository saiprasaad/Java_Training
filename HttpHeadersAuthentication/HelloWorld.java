package HttpHeadersAuthentication;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="HttpHeadersAuthentication.HelloWorld",name="HttpHeadersAuthentication")
public interface HelloWorld {
@WebMethod
public String getHelloWorldAsString();

}
