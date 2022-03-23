
package DP;
import java.io.*;
import java.util.*;
import java.math.*;

public class Solution{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) throws IOException
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0){
            int N = sc.nextInt(), M = sc.nextInt();
            int p[] = new int[N], w[] = new int[N], source[] = new int[M], destination[] = new int[M];
            for(int i = 0; i < N; i++) p[i] = sc.nextInt();
            for(int i = 0; i < N; i++) w[i] = sc.nextInt();

            for(int i = 0; i < M; i++) source[i] = sc.nextInt();
            for(int i = 0; i < M; i++) destination[i] = sc.nextInt();

            ab ob = new ab();
            long res = ob.findMin(N, M, p, w, source, destination);
            out.println(res);
        }
        out.flush();
    }
}// } Driver Code Ends


//User function Template for Java


class ab{
    
    static int inf = Integer.MAX_VALUE;
    
    static int[][] floydWarshall(int graph[][], int V)
    {
        int dist[][] = new int[V][V];
        int i, j, k;
        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];
        for (k = 0; k < V; k++)
        {
            for (i = 0; i < V; i++)
            {
                for (j = 0; j < V; j++)
                {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        return dist;
    }
    static long findMin(int N, int m, int p[], int w[], int s[], int d[]){
        int[][] adj = new int[N][N];
        for(int i = 1; i < N; i++){
            adj[i][p[i]] = 1;
            adj[p[i]][i] = 1;
        }
        for(int i = 0; i < N; i++){
            for(int j = 0;j < N;j++){
                if(adj[i][j] != 1){
                    adj[i][j] = inf;
                }
            }
        }
        
        int[][] allp = floydWarshall(adj,N);
        
        for(int i = 0; i < N; i++){
            for(int j = 0;j < N;j++){
                System.out.println(allp[i][j]);
            }
        }
        
        Arrays.sort(w);
        int[] pf = new int[N];
        pf[0] = w[0];
        for(int i = 1; i < N; i++){
            pf[i] = pf[i-1]+pf[i];
        }


        
        
        long sum = 0;
        
        // for(int i = 0; i < m; i++){
        //     sum += pf[];
        // }
        
        return sum;
    } 
}