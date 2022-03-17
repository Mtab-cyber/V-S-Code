
import java.util.Scanner;

public class Pattern {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = 1;
		
		for(int i = 0; i < n/2; i++) {
			for(int j = 0; j < n; j++) {
				if(i == 0) {
					System.out.print("*");
				}
				else if(i%2 == 0) {
					if(j == k || j == n-k) {
						System.out.print("*");
					}
					else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}
}
