package lab2;

public class Program05_NumberOfObjects {
	static int c;
	public Program05_NumberOfObjects() {
		c++;
	}
	public static void main(String[] args) {
		Program05_NumberOfObjects obj1=new Program05_NumberOfObjects();
		Program05_NumberOfObjects obj2=new Program05_NumberOfObjects();
		Program05_NumberOfObjects obj3=new Program05_NumberOfObjects();
		Program05_NumberOfObjects obj4=new Program05_NumberOfObjects();
		System.out.println("No of Objects for the class is "+c);
	}
}

