package lab4;

public class Program02 {
public void mth1()
{
	mth2();
	System.out.println("caller");
}
public void mth2() {
	try {
		throw new ArithmeticException();
		//return; // unreachable code
	}
	catch(Exception e) {System.out.println("catch-mth2");}
	finally {System.out.println("finally-mth2");}
}
public static void main(String[] args) {
	Program02 program02=new Program02();
	program02.mth1();
}
}
