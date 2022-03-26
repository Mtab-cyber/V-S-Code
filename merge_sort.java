import java.util.Scanner;

public class merge_sort {
	
	public static void merge(int[] arr, int l, int m, int r) {
		int ln = m-l+1;
		int rn = r-m;
		
		int[] left = new int[ln];
		int[] right = new int[rn];
		
		for(int i = 0 ; i < ln; i++) {
			left[i] = arr[i+l];
		}
		for(int j = 0; j < rn; j++) {
			right[j] = arr[j+m+1];
		}
		
		int i = 0, j = 0, k = l;
		
		while(i < ln && j < rn) {
			if(left[i] <= right[j]) {
				arr[k] = left[i];
				k++;
				i++;
			}
			else if(left[i] > right[j]) {
				arr[k] = right[j];
				k++;
				j++;
			}
		}
		
		while(i < ln) {
			arr[k] = left[i];
			i++;
			k++;
		}
		
		while(j < rn) {
			arr[k] = right[j];
			k++;
			j++;
		}
	}
	
	public static void sort(int[] arr,int l, int r) {
		if(l < r) {
			int m = l + (r-l)/2;
			
			sort(arr, l, m);
			sort(arr, m+1, r);
			
			merge(arr,l,m,r);
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
		sort(ar,0,n-1);
		for(int i : ar) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
