
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    try{
		    Scanner scan = new Scanner(System.in);
		    int t = scan.nextInt();
		    while(t-->0){
		        int n = scan.nextInt();
				ArrayList<String> arr = new ArrayList<>();
		        for(int i = 0; i < Math.pow(2,n); i++){
                    arr.add(Integer.toBinaryString(i));
                }
				Collections.sort(arr);
				System.out.println(arr);
				int count = 1;
				int temp = 0;
				int num = 0;
				for(String str : arr){
					num = 0;
					for(char ch : str.toCharArray()){
						if(ch == '1'){
							num++;
						}
					}
					if(temp == 0){
						count = num;
						temp++;
					}
					else if(num == count){
						temp++;
					}
					else{
						System.out.println(num+" - "+temp);
						count = 1;
						temp = 1;
					}
				}
		    }
		}catch(Exception e){
		    return;
		}
	}
}
