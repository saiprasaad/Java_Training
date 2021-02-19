package lab1;

public class Program08_LocationInArray {
	public static void main(String[] args) {
		int arr[]=new int[] {1,2,3,4,5};
		int val,index;
		val=4; //present in the array
//		val=6; not present in the array
		index=findelement(arr,val);
		if(index>=0)
			System.out.println("The index of the element in the array is "+index);
		else
			System.out.println("The element not found in the array");
	}
	
	static int findelement(int arr[],int val){
		int i;
		for(i=0;i<arr.length;i++)
		{
			if(arr[i]==val)
				return i;
		}
		return -1;
	}
}
