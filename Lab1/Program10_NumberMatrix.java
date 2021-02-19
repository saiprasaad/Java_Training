package lab1;

import java.util.Scanner;

public class Program10_NumberMatrix {
	public static void main(String[] args) {
		int m,n,i,j,c=1; //m rows n columns
		Scanner scan=new Scanner(System.in);
		m=scan.nextInt();
		n=scan.nextInt();
		int[][] mat=new int[m][n];
		for(i=0;i<m;i++)
		{
			for(j=0;j<n;j++)
			{
				mat[i][j]=c;
				c++;
			}
		}
		for(i=0;i<m;i++)
		{
			for(j=0;j<n;j++)
			{
				System.out.print(mat[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
