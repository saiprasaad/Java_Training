package lab1;

public class Program17a_ModifyConstantVariable {
	public static void main(String[] args) {
		final int val=10;
		val=20;//it will throw a compile time error as we cannot change the value of constant/final variable
	}
}
