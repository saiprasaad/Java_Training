package lab1;

public class Program26_Semicolon {
	public static void main(String[] args) {
		int i=-243;
		int j=243;
		if(i==j); // semicolon must be removed for the if statement to work properly
		System.out.println("Two numbers are same");
	}
}
