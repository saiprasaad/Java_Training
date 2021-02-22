package Day5LabBook;
class Baseclass1{
	Baseclass1(int i){
System.out.println("base constructor");
}
	Baseclass1(){
}
}
public class Program40_Sup extends Baseclass1{
public static void main(String argv[]){
	Program40_Sup s= new Program40_Sup();
	
//One
	// super(10);// must be first line in the constructor
}
Program40_Sup()
{
//Two
	super(10);
}
public void derived()
{
//Three
	//super(10);// must be first line in the constructor
}
}