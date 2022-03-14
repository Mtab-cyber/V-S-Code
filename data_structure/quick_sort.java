package data_structure;

import java.util.Scanner;

public class quick_sort {
	
	static void sort(int[] ar, int p, int r) {
		if(p<r) {
			 int q = partition(ar,p,r);
			 sort(ar,p,q-1);
			 sort(ar,q+1,r);
		}
	}
	
	static int partition(int[] ar, int p, int r) {
		int x = ar[r];
		int i = p-1;
		
		for(int j = p; j < r; j++) {
			if(ar[j] <= x) {
				i++;
				int temp = ar[j];
				ar[j] = ar[i];
				ar[i] = temp;
			}
		}
		
		int temp = ar[i+1];
		ar[i+1] = ar[r];
		ar[r] = temp;
		
		return i+1;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of array : ");
		int n = scan.nextInt();
		int[] ar = new int[n];
		for(int i = 0; i < n; i++) {
			ar[i] = scan.nextInt();
		}
		sort(ar,0,n-1);
		for(int i : ar) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

}
