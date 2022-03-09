package Problem;
import java.io.*;

class knapsack
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split(" ");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split(" "); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            new Solution();
			//calling method knapSack() of class Knapsack
            System.out.println(Solution.knapSack(w, wt, val, n));
            
            for(int i = 0; i < 1002; i++) {
            	for(int j = 0; j < 1002; j++) {
            		System.out.print(Solution.dp[i][j]+"  ");
            	}
            	System.out.println();
            }
        }
    }
}



// } Driver Code Ends


class Solution 
{ 
    public static int[][] dp = new int[1002][1002];
    Solution(){
        for(int i = 0; i < 1002; i++){
            for(int j = 0;j < 1002; j++){
                dp[i][j] = -1;
            }
        }
    }
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        if(W == 0 || n == 0){
            return 0;
        }
        
        if(dp[n][W] != -1){
            return dp[n][W];
        }
        
        if(W < wt[n-1]){
            return dp[n][W] = knapSack(W, wt, val, n-1);
        }
        
        return dp[n][W] = Math.max(val[n-1] + knapSack(W - wt[n-1] , wt, val, n-1) , knapSack(W, wt, val, n-1));
    } 
}





