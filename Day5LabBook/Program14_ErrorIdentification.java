package Day5LabBook;

public class Program14_ErrorIdentification {
	public static void main(String[] args) {
		/* type mismatch as the condition must be boolean
		 * int i=0;
		if(i) { 
		System.out.println("Hello");
		}
		*/
		boolean b=true;
		boolean b2=true;
		if(b==b2) {
		System.out.println("So true");
		}
		int i=1;
		int j=2;
		if(i==1|| j==2)
		System.out.println("OK");
		/* error as the symbol must be either && or || cannot be &|
		int i=1;
		int j=2;
		if(i==1 &| j==2)
		System.out.println("OK");
		*/
	}
}
