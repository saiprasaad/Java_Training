package lab1;

import java.util.Scanner;

public class Program13_StudentsMarks {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int students,subjects,i,j,sum=0,total;
		System.out.println("Enter number of Students ");
		students=scan.nextInt();
		System.out.println("Enter number of Subjects ");
		subjects=scan.nextInt();
		total=subjects*100;
		int[][] marks=new int[students][subjects];
		for(i=0;i<students;i++)
		{
			System.out.println("Enter the marks of student "+(i+1)+" out of 100");
			for(j=0;j<subjects;j++)
			{
				marks[i][j]=scan.nextInt();
			}
		}
		for(i=0;i<students;i++)
		{
			for(j=0;j<subjects;j++)
			{
				sum+=marks[i][j];
			}
			System.out.println("The Result of student "+(i+1)+" is "+sum+"/"+total);
			sum=0;
		}
	}
}
