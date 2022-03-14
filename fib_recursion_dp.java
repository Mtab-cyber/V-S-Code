import java.util.Scanner;

public class fib_recursion_dp {
    static int fib(int n,int dp[]){
        if(n <= 1){
            return 1;
        }

        if(dp[n] != 0){
            return dp[n];
        }

        return fib(n-1,dp)+fib(n-2,dp);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] dp = new int[1024];

        System.out.println(fib(n,dp));
    }
}
