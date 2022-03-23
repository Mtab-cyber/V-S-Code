package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BSD {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            char[] ch = br.readLine().toCharArray();//Stack<Character> stk = new Stack<>();
            int r = 0;
            int c = 0;
            int j = 0;
            int i = 0;
            for(i = 0; i < ch.length-1; i+=2){
                if(ch[i] == '(' && ch[i+1] == ')'){
                    r++;
                }
                else if(ch[i] == ')' && ch[i+1] == ')'){
                    r++;
                }
                else if(ch[i] == '(' && ch[i+1] == '('){
                    r++;
                }
                else{
                    j = i+2;
                    while(j < n && ch[j] != ')')j++;
                    if(j < n){
                        r++;
                        i = j-1;
                    }
                    else break;
                }
            }
            System.out.println(r+" "+(n-i));
        }
    }
}
