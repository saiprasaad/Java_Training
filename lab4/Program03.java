package lab4;

public class Program03 {
public void mth1()
{
	mth2();
	System.out.println("caller");
}
public void mth2() {
	try {
		throw new ArithmeticException();
	//	System.exit(0); unreachable code
	}
	catch(Exception e) {System.out.println("catch-mth2");}
	finally {System.out.println("finally-mth2");}
}
public static void main(String[] args) {
	Program03 program03=new Program03();
	program03.mth1();
}
}
