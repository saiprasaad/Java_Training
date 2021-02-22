package Day5LabBook;

public class Program45_Ref{
public static void main(String argv[]){
	Program45_Ref r = new Program45_Ref();
r.amethod(r);
}
public void amethod(Program45_Ref r){
int i=99;
multi(r);
System.out.println(i);
}
public void multi(Program45_Ref r){
//r.i = r.i*2; // 'i' is a varibale created inside a method so throws error at compile time 
}
}
