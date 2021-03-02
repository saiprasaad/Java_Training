package lab4;

public class Program06 {
	
}
class BaseClass extends Exception{
	public BaseClass(String s) 
    { 
		System.out.println("Base class exception caught");
    }
}
class DerivedClass extends Program06{
	public DerivedClass() {
		try {
			throw new BaseClass("sai");
		} catch (BaseClass e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
