package lab1;

import java.util.Scanner;

public class Program07_Sort {
	public static void main(String[] args) {
		int[] arr=new int[] {1,5,2,4,6};
		int i;
		char c;
		Scanner scan=new Scanner(System.in);
		System.out.println("Type a option 'a' for ascending and 'd' for descending");
		c=scan.next().charAt(0);
		sort(arr,c);
		for(int j:arr)
		{
			System.out.print(j+" ");
		}
		
	}
	
	static void sort(int arr[],char option) { 
	        int n = arr.length; 
	        if(option=='a')
	        {
		        for (int i = 0; i < n-1; i++) 
		            for (int j = 0; j < n-i-1; j++) 
		                if (arr[j] > arr[j+1]) 
		                { 
		                    int temp = arr[j]; 
		                    arr[j] = arr[j+1]; 
		                    arr[j+1] = temp; 
		                } 
		    } 
	        else if(option=='d')
	        {
	        	for (int i = 0; i < n-1; i++) 
		            for (int j = 0; j < n-i-1; j++) 
		                if (arr[j] < arr[j+1]) 
		                { 
		                    int temp = arr[j]; 
		                    arr[j] = arr[j+1]; 
		                    arr[j+1] = temp; 
		                } 
	        }
	}
}
