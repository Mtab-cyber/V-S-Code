package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Stair_Path {

    private static ArrayList<String> getAllPath(int n){
        if(n == 0){
            ArrayList<String> arr = new ArrayList<>();
            arr.add("");
            return arr;
        }
        else if(n < 0){
            ArrayList<String> arr = new ArrayList<>();
            return arr;
        }

        ArrayList<String> path1 = getAllPath(n-1);
        ArrayList<String> path2 = getAllPath(n-2);
        ArrayList<String> path3 = getAllPath(n-3);

        ArrayList<String> ans = new ArrayList<>();
        for(String p1 : path1){
            ans.add(1+p1);
        }
        for(String p2 : path2){
            ans.add(2+p2);
        }
        for(String p3 : path3){
            ans.add(3+p3);
        }

        return ans;
    }
    public static void main(String[] args)throws IOException {
        long start, end;
        int n = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in)).readLine()));
        start = System.currentTimeMillis();
        ArrayList<String> arr = getAllPath(n);
        end = System.currentTimeMillis();
        System.out.println(arr);
        System.out.println("Execution time "+(end-start));
    }
}
