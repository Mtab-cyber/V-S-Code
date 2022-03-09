package data_structure;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class diagnal_print {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] ar = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				ar[i][j] = scan.nextInt();
			}
		}
		
		HashMap<Integer,String> hm = new LinkedHashMap<Integer,String>();
		
		for(int i = n-1; i >= 0; i--) {
			for(int j = n-1; j >= 0; j--) {
				int sum = i+j;
				if(hm.containsKey(sum)) {
					hm.replace(sum, hm.get(sum) + " "+ar[i][j]);
				}
				else {
					hm.put(sum, "" + ar[i][j]);
				}
			}
		}
		System.out.println(hm);
	}
}
