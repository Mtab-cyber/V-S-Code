
import java.util.Scanner;

public class matrix_multiplication {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] arr1 = new int[n][n];
		for(int i = 0 ;i  < n; i ++) {
			for(int j = 0 ; j < n ; j++) {
				arr1[i][j] = scan.nextInt();
			}
		}
		
		int m = scan.nextInt();
		int[][] arr2 = new int[m][m];
		for(int i = 0 ;i  < n; i ++) {
			for(int j = 0 ; j < n ; j++) {
				arr2[i][j] = scan.nextInt();
			}
		}
		
		
		int[][] arr3 = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j  = 0; j < n; j++) {
				int sum = 0;
				for(int k = 0; k < m; k++) {
					sum += arr1[i][k] * arr2[k][j];
				}
				arr3[i][j] = sum;
			}
		}
		for(int[] i : arr3) {
			for(int j : i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}
