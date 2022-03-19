package Recursion;

import java.util.Scanner;

public class PlaceKnigth {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int r = scan.nextInt();
        int c = scan.nextInt();
        long a = System.currentTimeMillis();
        placeKnigth(new int[n][n],r,c,1,0);
        long b = System.currentTimeMillis();
        System.out.println("Execution time : "+(b-a));
    }

    private static void placeKnigth(int[][] is, int r, int c, int m, int c1) {
        if(r < 0 || r >= is.length || c < 0 || c >= is.length || is[r][c] != 0){
            return;
        }
        else if(r == is.length - 1 && c == is.length - 1){
            is[r][c] = m;
            for(int x = 0; x < is.length; x++){
                for(int y = 0; y < is.length; y++){
                    System.out.print(is[x][y]+" ");
                }
                System.out.println();
            }
            is[r][c] = 0;
            System.out.println();
               // System.exit(0);
            return;
        }
        is[r][c] = m;
        placeKnigth(is, r+1, c+2, m+1,c1);
        placeKnigth(is, r+1, c-2, m+1,c1);
        placeKnigth(is, r-1, c+2, m+1,c1);
        placeKnigth(is, r-1, c-2, m+1,c1);
        placeKnigth(is, r+2, c+1, m+1,c1);
        placeKnigth(is, r+2, c-1, m+1,c1);
        placeKnigth(is, r-2, c+1, m+1,c1);
        placeKnigth(is, r-2, c-1, m+1,c1);
        is[r][c] = 0;
    }
}
