package Day5LabBook;

public class Program51_Scope{
private int i;
public static void main(String argv[]){
	Program51_Scope s = new Program51_Scope();
s.amethod();
}//End of main
public static void amethod(){
//System.out.println(i); // throws compile time error
}//end of amethod
}//End of class
