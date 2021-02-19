package lab1;

public class Program22_AccessSpecifier {

	public static void main(String[] args) {
		AccessSpecification accessobj=new AccessSpecification();
		System.out.println("Private Variable Value"+accessobj.privatevar); // Private Variable not accessible
		System.out.println("Protected Variable Value"+accessobj.protectedvar);
		System.out.println("Default Variable Value"+accessobj.nomodifiervar);
		System.out.println("Public Variable Value"+accessobj.publicvar);
	    accessobj.privateTest();  //Private Method Not accessible
	    accessobj.protectedTest();
	    accessobj.defaultMethod();
		accessobj.publicTest();
	}

}

class AccessSpecification{
	/**variables*/
	int nomodifiervar=2;
	private int privatevar=3;
	protected int protectedvar=5;
	public int publicvar=7;
	
	/**methods*/
	private void privateTest() {
		System.out.println("Private Method");
	}
	protected void protectedTest() {
		System.out.println("Protected Method");
	}
	void defaultMethod() {
		System.out.println("Default Method");
	}
	public void publicTest() {
		System.out.println("Public Method");
	}
}
