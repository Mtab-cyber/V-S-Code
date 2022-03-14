package data_structure;
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        boolean[] p = new boolean[1000010];
        Arrays.fill(p,true);
        p[0] = false;
        p[1] = false;
        int sqrt = (int)Math.sqrt(p.length);
        for(int i = 2; i <= sqrt; i++){
            if(p[i]){
                for(int j = i*i; j < p.length; j+=i ){
                    p[j] = false;
                }
            }
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = scan.nextInt();
        while(t-->0){
            int n = scan.nextInt();
            int total = 0;
            for(int i = 2; i <=n; i++){
                if(p[i] && p[2*i+1]){
                    total += i;
                }
            }
            sb.append(total).append("\n");
        }
        System.out.println(sb);
    }
}