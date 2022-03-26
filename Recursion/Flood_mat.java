package Recursion;

import java.util.Arrays;
import java.util.Scanner;

public class Flood_mat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0;j < m; j++){
                arr[i][j] = scan.nextInt();
            }
        }
        boolean[][] vis = new boolean[n][m];
        //Arrays.fill(vis, false);
        printPath(arr,0,0,"",vis);
    }

    private static void printPath(int[][] arr, int i, int j, String out, boolean[][] vis) {
        if(i < 0 || j < 0 || i == arr.length || j == arr[0].length || arr[i][j] == 1 || vis[i][j]){
            return;
        }

        if(i == arr.length-1 && j == arr[0].length - 1){
            System.out.println(out);
            return;
        }
        vis[i][j] = true;
        printPath(arr, i+1, j, out+"d", vis);
        printPath(arr, i, j+1, out+"r", vis);
        printPath(arr, i-1, j, out+"u", vis);
        printPath(arr, i, j-1, out+"l", vis);
    }
}
