package Day5LabBook;

public class Program13_SwitchCase {
	public static void main(String[] args) {
		int i=1;
		switch (i) {
		case 0:
		System.out.println("zero");
		break;
		case 1:
		System.out.println("one"); // as there is not break in case 1 & 2 the successive cases are also executed
		case 2:
		System.out.println("two");
		default:
		System.out.println("default");
		}
	}
}
