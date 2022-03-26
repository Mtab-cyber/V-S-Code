package DP;

import java.util.Scanner;

public class fibnocci {
    static int dp[] = new int[1024];

    private static int getfib(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        return dp[n] = getfib(n-1)+getfib(n-2);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long a = System.currentTimeMillis();
        int fib = getfib(n);
        long b = System.currentTimeMillis();
        System.out.println(fib+"\nExecution time : "+(b-a));
    }
}
