package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class KeyPad_Comb {
    static String[] comb = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    private static ArrayList<String> getComb(String str){
        if(str.length() == 0){
            ArrayList<String> arr = new ArrayList<>();
            arr.add("");
            return arr;
        }

        char ch = str.charAt(0);
        ArrayList<String> res = getComb(str.substring(1));
        ArrayList<String> mres = new ArrayList<>();

        for(char in : comb[ch-'0'].toCharArray()){
            for(String sre : res){
                mres.add(in+sre);
            }
        }

        return mres;

    }
    public static void main(String[] args)throws IOException {
        String str = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        ArrayList<String> arr = getComb(str);
        System.out.println(arr);
    }
}
