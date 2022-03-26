package Recursion;

import java.util.Scanner;

public class N_Queen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long a = System.currentTimeMillis();
        placeQueen(new int[n][n],0,"");
        long b = System.currentTimeMillis();
        System.out.println("Execution time : "+(Math.abs(a-b))+" ms");
    }

    private static void placeQueen(int[][] arr, int row, String out) {
        if(row == arr.length){
            System.out.println(out);
            return;
        }

        for(int i = 0; i < arr[row].length; i++){
            if(isSafe(arr,row,i)){
                arr[row][i] = 1;
                placeQueen(arr, row+1, out+(row+1)+"-"+(i+1)+",");
                arr[row][i] = 0;
            }
        }
    }

    private static boolean isSafe(int[][] arr, int row, int col) {
        for(int i = row-1; i >= 0; i--){
            if(arr[i][col] == 1)
                return false;
        }

        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--){
            if(arr[i][j] == 1){
                return false;
            }
        }
        
        for(int i = row-1, j = col+1; i >= 0 && j < arr[i].length; i--, j++){
            if(arr[i][j] == 1){
                return false;
            }
        }

        return true;
    }
}
