package lab1;

import java.util.Scanner;

public class Program11_NumberMatrix {
		public static void main(String[] args) {
			int n,i,j,c=1;
			Scanner scan=new Scanner(System.in);
			n=scan.nextInt();
			int[][] mat=new int[n][n];
			for(i=0;i<n;i++)
			{
				for(j=0;j<=i;j++)
				{
					mat[i][j]=c;
					c++;
				}
			}
			for(i=0;i<n;i++)
			{
				for(j=0;j<=i;j++)
				{
					System.out.print(mat[i][j]+"\t");
				}
				System.out.println();
			}
		}

}
