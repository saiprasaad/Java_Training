package lab4;

class UserdefinedException extends Exception 
{ 
    public UserdefinedException(String s) 
    { }
} 
public class Program04 {
	public static void main(String[] args) {
		try {
			throw new UserdefinedException("sai");
		}
		catch(Exception e) {e.printStackTrace();}
	}
}
