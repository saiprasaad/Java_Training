package HttpHeadersAuthentication;

import javax.xml.ws.Endpoint;
//Endpoint publisher
public class HelloWorldPublisher{
public static void main(String[] args) {
System.out.println("service ready....");
Endpoint.publish("http://localhost:8888/ws/hello", new HelloWorldImpl());
}
}