package Day5LabBook;

public class Program36_EqTest{
public static void main(String argv[]){
Program36_EqTest e=new Program36_EqTest();
}
Program36_EqTest(){
String s="Java";
String s2="java";
if(s.equalsIgnoreCase(s2)) { // ignores the case while checking return true
System.out.println("Equal");
}
else
{
System.out.println("Not equal");
}
}
}