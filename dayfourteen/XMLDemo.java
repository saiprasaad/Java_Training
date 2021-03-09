package dayfourteen;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
public class XMLDemo {
public static void main(String[] args)throws Exception {
	DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
	dbf.setIgnoringElementContentWhitespace(true);
	dbf.setValidating(true);
	
	
	DocumentBuilder db=dbf.newDocumentBuilder();
	
	Document doc=db.parse("C:\\Java\\java_training\\eycorejava\\src\\dayfourteen\\books.xml");
	
	System.out.println(doc.getDocumentElement().getNodeName());
	System.out.println(doc.getDocumentElement().getChildNodes());
	
	Element rootElement=doc.getDocumentElement();
	
	for(int i=0;i<rootElement.getChildNodes().getLength();i++) {
		for(int j=0;j<rootElement.getChildNodes().item(i).getChildNodes().getLength();j++) {
			System.out.println(rootElement.getChildNodes().item(i).getChildNodes().item(j).getFirstChild().getNodeValue());
		}
	}
	
//	System.out.println(rootElement.getFirstChild().getNodeName());
//	System.out.println(rootElement.getNodeType());
//	System.out.println(rootElement.getFirstChild().getAttributes().getNamedItem("name").getNodeValue());
//	System.out.println(rootElement.getFirstChild().getFirstChild().getNodeType());
//	System.out.println(rootElement.getFirstChild().getFirstChild().getFirstChild());
//	System.out.println(rootElement.getFirstChild().getFirstChild().getFirstChild().getNodeType());
//	
}
}