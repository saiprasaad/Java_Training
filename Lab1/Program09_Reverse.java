package lab1;

public class Program09_Reverse {
	public static void main(String[] args) {
		int[] arr=new int[] {1,2,3,4,5};
		int i;
		reverse(arr);
		for(i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}
	static void reverse(int arr[])
	{
		int i,temp,j=arr.length-1;
		for(i=0;i<arr.length/2;i++)
		{
			temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			j--;
		}
	}
}
