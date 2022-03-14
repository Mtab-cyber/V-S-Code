package data_structure;/* package codechef; // don't place package name! */
/* package codechef; // don't place package name! */
/* package codechef; // don't place package name! */
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    try{StringBuilder sb = new StringBuilder();
	    Scanner scan = new Scanner(System.in);
	    int t = scan.nextInt();
	    while(t-->0){
	        int n = scan.nextInt();
	        int k = scan.nextInt();
	        scan.nextLine();
	        String str = scan.nextLine();
	        
	        int ans = Integer.parseInt(str.substring(0,k));
	        
	        for(int i = 1; i < n-k+1; i++){
	            int l = Integer.parseInt(str.substring(i,i+k));
	            ans = ans ^ l;
	            
	        }
	        
	        int count = 0;
	        
	        while(ans > 0){
	            count += ans%10;
	            ans/=10;
	        }
	        sb.append(count).append("\n");
	    }
	    System.out.println(sb);
	    }catch(Exception e){
		    return;
		}
	 }
	    
	}
