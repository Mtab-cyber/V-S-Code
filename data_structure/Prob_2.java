package data_structure;

import java.util.Arrays;
import java.util.Scanner;

public class Prob_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0) {
			int n = scan.nextInt();
			int x = scan.nextInt();
			int[] ar = new int[n];
			for(int i = 0; i < n; i++) {
				ar[i] = scan.nextInt();
			}
			if(x<=n/2) {
				System.out.println("YES");
			}
			else {
				int temp = (x-1)-(n-x);
				if(temp > 1) {
					int c = 0;
					int[] temp_ar = new int[n];
					for(int k = 0; k < n; k++) {
						temp_ar[k] = ar[k];
					}
					Arrays.sort(temp_ar);
					for(int i = (n-x); i < x; i++) {
						if(ar[i]!=temp_ar[i]) {
							System.out.println("NO");
							c = 1;
							break;
						}
					}
					if(c==0) {
						System.out.println("YES");
					}
				}
				else
					System.out.println("YES");
			}
		}
		scan.close();
	}
}
