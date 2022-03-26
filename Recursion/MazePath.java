package Recursion;

import java.io.*;
import java.util.ArrayList;

public class MazePath {

    private static ArrayList<String> getPath(int si, int sj, int di, int dj){
        if(si == di && sj == dj){
            ArrayList<String> arr = new ArrayList<>();
            arr.add("");
            return arr;
        }
        else if(si == di+1 || sj == dj+1){
            ArrayList<String> arr = new ArrayList<>();
            return arr;
        }

        ArrayList<String> p1 = getPath(si+1, sj, di, dj);
        ArrayList<String> p2 = getPath(si, sj+1, di, dj);
        ArrayList<String> ans = new ArrayList<>();

        for(String str : p1){
            ans.add('D'+str);
        }
        for(String str : p2){
            ans.add('F'+str);
        }

        return ans;
    }
    public static void main(String[] args)throws IOException {
        long start, end;
        int n = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in)).readLine()));
        start = System.currentTimeMillis();
        ArrayList<String> arr = getPath(1,1,n,n);
        end = System.currentTimeMillis();
        System.out.println(arr);
        System.out.println("Execution time "+(end-start));
    }
}
