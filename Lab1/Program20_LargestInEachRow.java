package lab1;

public class Program20_LargestInEachRow {
	public static void main(String[] args) {
		int[][] mat=new int[][] {{1,4,2},{3,7,9},{6,4,2}};
		int i,j;
		for(i=0;i<3;i++)
		{
			System.out.println("Maximum element of Row "+(i+1)+"is "+findMax(mat[i]));
		}
	}
	static int findMax(int arr[])
	{
		int i,max=0;
		for(i=0;i<arr.length;i++)
		{
			if(arr[i]>max)
			{
				max=arr[i];
			}
		}
		return max;
	}
}
