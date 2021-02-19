package lab1;

import java.util.Scanner;

public class Program05_Average {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int i;
		Program05_Average avgobj=new Program05_Average();
		int arr[]=new int[] {1,5,2,6,4,7};
		System.out.println("The average of n values is "+avgobj.average(arr));
	}
	public double average(int arr[])
	{
		int i,sum=0,lengthvar=arr.length;
		for(i=0;i<lengthvar;i++)
			sum+=arr[i];
		return (double)sum/lengthvar;
	}
}
