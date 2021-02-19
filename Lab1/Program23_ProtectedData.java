package lab1;

public class Program23_ProtectedData {
	public static void main(String[] args) {
		ClassB classbobj=new ClassB();
		classbobj.method();
	}
}
class ClassA{
	protected int var=10;
}
class ClassB{
	public void method()
	{
		ClassA obj=new ClassA();
		System.out.println(obj.var);
	}
	
}

