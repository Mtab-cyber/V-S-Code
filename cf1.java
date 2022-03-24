import java.io.*;
import java.util.StringTokenizer;

public class cf1{

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble(){ return Double.parseDouble(next());}
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int t1 = scan.nextInt();
        StringBuilder sb = new StringBuilder();
        while(t1-->0){
            long n = scan.nextInt();
            if(n%2 == 0){
                System.out.println("2");
            }
            else if((n/2)%3 == 0){
                System.out.println("3");
            }
            else{
                
            }
        }
    }
}