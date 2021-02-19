package lab1;

import java.util.Scanner;

public class Program15b_NumberCheck {
	public static void main(String[] args) {
		int num;
		Scanner scan=new Scanner(System.in);
		num=scan.nextInt();
		if(ispalindrome(num))
		{
			System.out.println(num+" is a palindrome number");
		}
		else if(isarmstrong(num))
		{
			System.out.println(num+" is an armstrong number");
		}
		else if(isperfectnumber(num))
		{
			System.out.println(num+" is a perfect number");
		}
		else
		{
			System.out.println(num+ "is not a perfect number not an armstrong number not a palindrome number");
		}
	}
	public static boolean isarmstrong(int n)
	{
		int ans=0,num,temp=n;
		while(n>0)
		{
			num=n%10;
			ans+=(num*num*num);
			n=n/10;
		}
		if(temp==ans)
			return true;
		else
			return false;
	}
	public static boolean ispalindrome(int n)
	{
		int ans=0,num,temp=n;
		while(n>0)
		{
			num=n%10;
			ans=(ans*10)+num;
			n=n/10;
		}
		if(temp==ans)
			return true;
		else
			return false;
	}
	public static boolean isperfectnumber(int n)
	{
		int i,sum=0;
		for(i=1;i<=n/2;i++)
		{
			if(n%i==0)
				sum+=i;
		}
		if(sum==n)
			return true;
		else
			return false;
	}
}
