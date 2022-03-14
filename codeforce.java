import java.util.Scanner;

public class codeforce {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-->0){
            int n = scan.nextInt();
            int[] a = new int[n];

            for(int i = 0; i < n; i++){
                a[i] = scan.nextInt();
            }

            int[] b = new int[n];
            for(int i = 0; i < n; i++){
                b[i] = scan.nextInt();
            }

            long sa = Long.MAX_VALUE;
            long ea = Long.MAX_VALUE;
            long sb = Long.MAX_VALUE;
            long eb = Long.MAX_VALUE;

            long ser = Math.abs(a[0]-b[0]) + Math.abs(a[n-1]-b[n-1]);
            long cross = Math.abs(a[0]-b[n-1]) + Math.abs(a[n-1]-b[0]);

            long minm = Math.min(ser,cross);

            for(int i = 0; i < n; i++){
                sa = Math.min(sa,Math.abs(a[0]-b[i]));
                ea = Math.min(ea,Math.abs(a[n-1]-b[i]));
                sb = Math.min(sb,Math.abs(b[0]-a[i]));
                eb = Math.min(eb,Math.abs(b[n-1]-a[i]));
            }

            minm = Math.min(minm, Math.abs(a[0]-b[0]) + ea + eb);
            minm = Math.min(minm, Math.abs(a[n-1]-b[n-1]) + sb + sa);
            minm = Math.min(minm, Math.abs(a[0]-b[n-1]) + ea + sb);
            minm = Math.min(minm, Math.abs(a[n-1]-b[0]) + sa + eb);
            minm = Math.min(minm,ea+eb+sa+sb);
            System.out.println(minm);
        }
    }
}