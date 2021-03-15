package daysixteen;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class SAXDemo {
public static void main(String[] args)throws Exception {
SAXParserFactory spf=SAXParserFactory.newInstance();
SAXParser sp=spf.newSAXParser();
sp.parse("C:\\Java\\java_training\\eycorejava\\src\\daysixteen\\books.xml",new MyXMLHandler());
}
}
class MyXMLHandler extends DefaultHandler{
	public void startDocument() throws SAXException {
		System.out.println("parsing started..............");
		}
		@Override
		public void endDocument() throws SAXException {
		System.out.println("parsing ends.........");
		}
		@Override
		public void startElement(String uri, String localName, String
		qName, Attributes attributes) throws SAXException {
		System.out.print("<"+qName+">");
		}
		@Override
		public void endElement(String uri, String localName, String
		qName) throws SAXException {
		System.out.println("</"+qName+">");
		}
		@Override
		public void characters(char[] ch, int start, int length) throws
		SAXException {
		String s=new String(ch,start,length);
		System.out.print(s);
		}
}