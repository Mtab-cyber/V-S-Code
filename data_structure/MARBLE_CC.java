package data_structure;
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class MARBLE_CC
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    try{
		    Scanner scan = new Scanner(System.in);
		    int t = scan.nextInt();
		    while(t-->0){
		        int n = scan.nextInt();
		        scan.nextLine();
		        String str1 = scan.nextLine();
		        String str2 = scan.nextLine();
		        char[] ch1 = str1.toCharArray();
		        char[] ch2 = str2.toCharArray();
		        boolean cons = true;
		        for(int i = 0; i < n ;i++){
		            if((ch1[i] == '?' || ch2[i] == '?' ) && !(ch1[i] == ch2[i])){
		                char ch;
		                if(ch1[i] == '?'){
		                    ch = ch2[i];  
		                }
		                else{
		                    ch = ch1[i];
		                }
		                
		                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
		                    
		                }
		                else{
		                    cons = false;
		                }
		                break;
		            }
		        }
		        char ch;
		        if(cons){
		           ch = 'b'; 
		        }
		        else{
		            ch = 'a';
		        }
		        
		        for(int i = 0; i < n; i++){
		            if(ch1[i] == '?'){
		                ch1[i] = ch;
		            }
		            if(ch2[i] == '?'){
		                ch2[i] = ch;
		            }
		        }
		        
		        int count1 = 0;
		        for(int i = 0; i < n; i++){
		            if(ch1[i] != ch2[i]){
		                if(ch1[i] == 'a' || ch1[i] == 'e' || ch1[i] == 'i' || ch1[i] == 'o' || ch1[i] == 'u'){
		                    if(ch2[i] == 'a' || ch2[i] == 'e' || ch2[i] == 'i' || ch2[i] == 'o' || ch2[i] == 'u'){
		                        count1 += 2;
		                    }
		                    else{
		                        count1 += 1;
		                    }
		                }
		                else{
		                    if(ch2[i] == 'a' || ch2[i] == 'e' || ch2[i] == 'i' || ch2[i] == 'o' || ch2[i] == 'u'){
		                        count1 += 1;
		                    }
		                    else{
		                        count1 += 2;
		                    }
		                }
		            }
		        }
		        
		        
		        char[] ch11 = str1.toCharArray();
		        char[] ch22 = str2.toCharArray();
		        for(int i = 0; i < n ;i++){
		            if((ch11[i] == '?' || ch22[i] == '?' ) && !(ch11[i] == ch22[i])){
		                if(ch11[i] == '?'){
		                    ch = ch22[i];  
		                }
		                else{
		                    ch = ch11[i];
		                }
		                break;
		            }
		        }
		        for(int i = 0; i < n; i++){
		            if(ch11[i] == '?'){
		                ch11[i] = ch;
		            }
		            if(ch22[i] == '?'){
		                ch22[i] = ch;
		            }
		        }
		        
		        int count = 0;
		        for(int i = 0; i < n; i++){
		            if(ch11[i] != ch22[i]){
		                if(ch11[i] == 'a' || ch11[i] == 'e' || ch11[i] == 'i' || ch11[i] == 'o' || ch11[i] == 'u'){
		                    if(ch22[i] == 'a' || ch22[i] == 'e' || ch22[i] == 'i' || ch22[i] == 'o' || ch22[i] == 'u'){
		                        count += 2;
		                    }
		                    else{
		                        count += 1;
		                    }
		                }
		                else{
		                    if(ch22[i] == 'a' || ch22[i] == 'e' || ch22[i] == 'i' || ch22[i] == 'o' || ch22[i] == 'u'){
		                        count += 1;
		                    }
		                    else{
		                        count += 2;
		                    }
		                }
		            }
		        }
		        
		        System.out.println(Math.min(count1, count));
		    }
		}catch(Exception e){
		    return;
		}
	}
}
