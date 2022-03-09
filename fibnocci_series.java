package Problem;

import java.util.Scanner;

public class fibnocci_series {

	public static int[] dp = new int[1024];
	public static int series(int n) {
		if(n==0 || n==1) {
			return n;
		}
		
		if(dp[n] != 0) {
			return dp[n];
		}
		
		int fib1 = series(n-1);
		int fib2 = series(n-2);
		
		int sum = fib1+fib2;
		dp[n] = sum;
		
		return sum;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		series(n);
		System.out.println("Fibbnocci series : ");
		for(int i = 1; i <= n; i++) {
			if(i == 0)
				break;
			System.out.print(dp[i]+" ");
		}
		scan.close();
	}
}
