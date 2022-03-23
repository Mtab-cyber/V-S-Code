package data_structure;

import java.util.Scanner;

public class XY{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-->0){
            int n = scan.nextInt();
            int B = scan.nextInt();
            long x = scan.nextInt();
            long y = scan.nextInt();
            n++;
            long[] ar = new long[n];
            ar[0] = 0;
            for(int i = 1; i < n; i++){
                long a = ar[i-1]+x;
                if(a>B){
                    ar[i] = ar[i-1] - y;
                }
                else{
                    ar[i] = a;
                }
            }
            long sum = 0;
            for(int i = 0; i < n; i++){
                sum+=ar[i];
            }
            System.out.println(sum);
        }
    }
}