
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class LCS_DP {
	public static void main(String[] args)throws IOException {
		System.out.println("Enter both the string : ");
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String str1 = br.readLine();
//		String str2 = br.readLine();
		Scanner scan = new Scanner(System.in);
		String str1 = scan.nextLine();
		String str2 = scan.nextLine();
		
		int[][] dp = new int[str1.length()+1][str2.length()+1];
		char[][] pos = new char[str1.length()+1][str2.length()+1];
		
		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp[i].length; j++) {
				if(i == 0||j == 0) {
					dp[i][j] = 0;
					continue;
				}
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
					pos[i][j] = 'd';
				}
				else {
					if(dp[i-1][j] >= dp[i][j-1]) {
						dp[i][j] = dp[i-1][j];
						pos[i][j] = 'u';
					}
					else {
						dp[i][j] = dp[i][j-1];
						pos[i][j] = 's';
					}
				}
			}
		}
		
		Stack<Character> stk = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		int i = pos.length-1;
		int j = pos[0].length-1;
		
//		while(i > 0) {
			while(j > 0 && i > 0) {
				if(pos[i][j] == 'd') {
					stk.push(str1.charAt(i-1));
					i--;
					j--;
				}
				else if(pos[i][j] == 'u') {
					i--;
				}
				else {
					j--;
				}
			}
		//}
		
		
		while(!stk.empty()) {
			sb.append(stk.pop());
		}
		
		
		System.out.println(sb);
	}
}
