package lab1;

public class Program19_ReverseElements {
	public static void main(String[] args) {
		int row=3,col=3;
		int[][] mat=new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		int[][] reversemat=new int[row][col];
		int i,j;
		for(i=0;i<row;i++)
		{
			for(j=0;j<col;j++)
			{
				reversemat[i][j]=mat[i][col-j-1];
			}
		}
		for(i=0;i<row;i++)
		{
			for(j=0;j<col;j++)
			{
				System.out.print(reversemat[i][j]+" ");
			}
			System.out.println();
		}
	}
}
