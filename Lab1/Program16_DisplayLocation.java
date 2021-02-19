package lab1;

public class Program16_DisplayLocation {
	public static void main(String[] args) {
		int arr[]=new int[] {1,2,2,3,4,5};
		int count=findLocationAndFrequency(arr,2);
		System.out.println("The element occured "+count+" times");
	}
	static int findLocationAndFrequency(int arr[],int value)
	{
		int c=0,i;
		for(i=0;i<arr.length;i++)
		{
			if(arr[i]==value)
			{
				System.out.println("Element "+value+" is Found at Index "+i);
				c++;
			}
		}
		return c;
	}
}
