package daysixteen;

public class StringFormatting {
	public static void main(String[] args) {
		System.out.printf("Integer value...%d\n", 200);
		System.out.printf("String value...%s\n", "hello");
		System.out.printf("Float value...%.3f", 200.978655);
		
		String s = String.format("\nString: %s, Integer: %06d, Float: %f", "hi", 700, 89.97);
		System.out.println(s);
		
		System.out.printf("\n %-15s %-15s %-15s", "Col1", "Col2", "Col3");
		System.out.printf("\n %-10s %-10s %-10s", "Col1", "Col2", "Col3");
		System.out.printf("\n %s\t%s\t%s", "Col1", "Col2", "Col3");
		System.out.println("This is before\fNow new line");
		System.out.println("TEXTBEFORE\rOverlap");
		System.out.println("12\b3");
	}
}