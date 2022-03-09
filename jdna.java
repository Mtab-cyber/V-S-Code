package data_structure;


import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

class jdna{
   
    public static void main (String[] args) throws java.lang.Exception
    {
	    try{
		    Scanner scan = new Scanner(System.in);
		    int n = scan.nextInt();
		    scan.nextLine();
		    String str = scan.nextLine();
		    HashMap<String,Integer> map = new HashMap<>();
		    int max = 0;
		    for(int i = 0; i < n; i++) {
		        for(int j = i+1; j < n; j++){
		            if(map.containsKey(str.substring(i,j))){
		                map.put(str.substring(i,j),map.get(str.substring(i,j))+1);
		            }
		            else{
		                map.put(str.substring(i,j),1);
		            }
		        }
		    }
		    Set<String> Key = map.keySet();
		        for(String key : Key){
		            if(map.get(key) > 1){
		                if(max > map.get(key)){
		                    max = map.get(key);
		                }
		            }
		        }
		        System.out.println(max);
		    
		}catch(Exception e){
		    return;
		}
    }
}