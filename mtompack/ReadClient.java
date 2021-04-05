package mtompack;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
public class ReadClient{
public static void main(String[] args) throws
Exception {
URL url = new
URL("http://localhost:8888/ws/hello?wsdl");
QName qname = new QName("http://mtompack/","MtomServiceService");
Service service = Service.create(url, qname);
MtomInter mtom=service.getPort(MtomInter.class);
Image img= mtom.getImage("hills.jpg");
JFrame frame = new JFrame();
frame.setSize(300, 300);
JLabel label = new JLabel(new ImageIcon(img));
frame.add(label);
frame.setVisible(true);
}}