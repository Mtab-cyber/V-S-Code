package data_structure;

import java.util.Scanner;

public class heap_sort{
	
	public static void sort(int[] arr, int n) {
		for(int i = n/2; i >= 0; i--) {
			heapify(arr,n,i);
		}
		
		for(int i = n-1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			heapify(arr,i,0);
		}
	}
	
	public static void heapify(int[] arr, int n, int l) {
		int largest = l;
		int left = 2*l+1;
		int right = 2*l+2;
		
		if(left < n && arr[left] > arr[largest])
			largest = left;
		
		if(right < n && arr[right] > arr[largest])
			largest = right;
		
		if(largest != l) {
			int temp = arr[largest];
			arr[largest] = arr[l];
			arr[l] = temp;
			
			heapify(arr,n,largest);
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of array : ");
		int n = scan.nextInt();
		int[] ar = new int[n];
		for(int i = 0; i < n; i++) {
			ar[i] = scan.nextInt();
		}
		sort(ar,n);
		for(int i : ar) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
}