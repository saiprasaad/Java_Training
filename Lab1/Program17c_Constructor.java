package lab1;

public class Program17c_Constructor {
	public static void main(String[] args) {
		 HelloWorldClass hw=new HelloWorldClass(); // throws error as we have to pass some value in the constructor
	}
}
	class HelloWorldClass
	{
		HelloWorldClass(int a)
		{
			System.out.println("Hello World With Args Constructor");
		}
	}
