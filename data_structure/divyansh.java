
import java.util.Scanner;

public class divyansh {
static int mod = (int)(1000000007);

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] ar = new int[n];
        for(int i = 0; i < n; i++){
            ar[i] = scan.nextInt();
        }
        int k = scan.nextInt();
        int out = solve(n,ar,k);
        System.out.println(out);
    }

    private static int solve(int n, int[] ar, int k) {

        int cnt = 0;
        for (int i = 0; i < (1<<n); i++)
        {
            int sum = 0;
            for (int j = 0; j < n; j++)
            {
                if ((i & (1 << j)) > 0)
                    sum += ar[j];
            }
            if(sum <= k){
                cnt = (cnt+1)%mod;
            }
        }

        return cnt-1;
    }
}
