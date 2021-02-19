package lab1;
/** This class is used an example to show
 *  how javadoc command works 
 */
public class Program14a_javadoc {
	public static void main(String[] args) {
		int num1=2,num2=3,sum=0;
		sum=add(num1,num2);
		System.out.println("Sum of two numbers is "+sum);
	}
	
	static int add(int num1,int num2) {
		return num1+num2;
	}
}
