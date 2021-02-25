package lab2;

class SingletonClass {
	private static SingletonClass obj=new SingletonClass();
	private SingletonClass() {}
	public static SingletonClass retriveInstance() {
		return obj;
	}
	public static void method() {
		System.out.println("Method called");
	}

}
class Program08_SingletonClass
{
	public static void main(String[] args) {
		SingletonClass object=SingletonClass.retriveInstance();
		object.method();
	}
}
