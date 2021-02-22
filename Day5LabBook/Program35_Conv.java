package Day5LabBook;

public class Program35_Conv{
public static void main(String argv[]){
	Program35_Conv c=new Program35_Conv();
String s=new String("ello");
c.amethod(s);
}
public void amethod(String s){
char c='H';
// c+=s; cannot concatenate character and string
System.out.println(c);
}
}