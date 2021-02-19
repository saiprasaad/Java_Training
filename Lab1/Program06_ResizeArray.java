package lab1;

import java.util.Arrays;

public class Program06_ResizeArray {
	public static void main(String[] args) {
		int[] arr=new int[] {1,6,3,4,2};
		System.out.println("The length of original array "+arr.length);
		arr=Arrays.copyOf(arr, 4);
		System.out.println("The length of modified array "+arr.length);
	}
}
