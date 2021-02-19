package lab1;

public class Program27_Investment {
	public static void main(String[] args) {
		double temp=14000+(0.40*14000);
		System.out.println("The amount is: "+temp+" at the end of First Year");
		temp=temp-1500;
		System.out.println("The amount is: "+temp+" at the end of Second Year");
		temp=(temp*0.12)+temp;
		System.out.println("The amount is: "+temp+" at the end of Third Year");
	}
}
