package data_structure;

import java.util.Arrays;
import java.util.Scanner;

public class N_Queen {
	public static int size;
	
	public static void print(int[][] b) {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static boolean isSafe(int b[][], int r, int c) {
		int i, j;
		
		for(i = 0; i < c; i++) {
			if(b[r][i] == 1) {
				return false;
			}
		}
		
		for(i = r, j = c; i >= 0 && j >= 0; i--, j--) {
			if(b[i][j] == 1) {
				return false;
			}
		}
		
		for (i = r, j = c; j >= 0 && i < size; i++, j--)
            if (b[i][j] == 1)
                return false;
 
        return true;
	}
	public static boolean solve(int b[][], int col) {
		if(col >= size) {
			return true;
		}
		
		for(int i = 0; i < size; i++) {
			if(isSafe(b,i,col)) {
				b[i][col] = 1;
				
				if(solve(b,col+1)) {
					return true;
				}
				b[i][col] = 0;
			}
		}
		return false;
	}
	public static boolean nq(int n, int[][] b) {
		if(solve(b,0) == false) {
			System.out.println("Solution doesn't exist ");
			return false;
		}
		
		print(b);
		
		return true;
	}
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of the board :- ");
		size = scan.nextInt();
		
		int[][] board = new int[size][size];
		
		nq(size,board);
		
		scan.close();
	}

}
