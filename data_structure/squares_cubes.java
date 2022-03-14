package data_structure;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class squares_cubes {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		
		while(t-->0) {
			long l = scan.nextLong();
			long an = scan.nextLong();
			
			long result = 0;
			
			if(an < l) {
				System.out.println("-1");
			}
			else if(an == l) {
				System.out.println("0");
			}
			else {
				while(an > 0) {
					if(an%10 > l % 10) {
						long x = an%10 - l%10;
						
					}
				}
				
			}
		}
	}
}
