package Recursion;

import java.util.Scanner;

public class BS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        String str = scan.nextLine();
        int c1 = 0;
        int c0 = 0;
        int cq = 0;
        for(char ch : str.toCharArray()){
            if(ch == '1'){
                c1++;
            }
            else if(ch == '0'){
                c0++;
            }
            else{
                cq++;
            }
        }

        int max = Math.max(c0, c1);
        int min = Math.min(c0, c1);

        int diff = max - min;
        if(diff <= cq){
            min += diff;
            cq = cq-diff;
            int ans = min+max+(cq%2==0?cq:cq-1);
            System.out.println(ans);
        }
        // 
        else{
            int ans = min+cq;
            ans *= 2;
            System.out.println(ans);
        }
    }
}
