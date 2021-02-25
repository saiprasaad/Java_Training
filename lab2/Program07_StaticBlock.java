package lab2;

public class Program07_StaticBlock {
	static int a;
	static{
		System.out.println("Static block is executed");
		a=10;
	}
	public static void main(String[] args) {
		System.out.println("Value of a is "+a);
	}
}
