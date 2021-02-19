package lab1;

import java.util.Scanner;
import java.lang.Math;
public class Program04_CheckPrime {
	public static void main(String[] args) {
		int num,i,flag=0;
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter a number :");
		num=scan.nextInt();
		for(i=2;i<=Math.sqrt(num);i++)
		{
			if(num%i==0)
			{
				flag=1;
				break;
			}
		}
		if(flag==0)
			System.out.println(num+ " is a Prime Number");
		else
			System.out.println(num+ " is not a Prime Number");
	}
}
