
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Decoding {
	
	public static int ways(List<Integer> li, int p, int n) {
		if(p > n) {
			return 0;
		}
		
		if(p == n) {
			return 1;
		}
		
		if(p+1 < n && li.get(p) * 10 + li.get(p+1) <= 26) {
			return ways(li, p+1, n) + ways(li, p+2, n);
		}
		
		return ways(li, p+1, n);
	}

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int in = scan.nextInt();
		List<Integer> li = new ArrayList<Integer>();
		while(in>0) {
			li.add(in%10);
			in/=10;
		}
		for(int i : li) {
			System.out.print(i+" ");
		}
		int no_of_ways = ways(li, 0, li.size()-1);
		
		System.out.println(no_of_ways);
		scan.close();
	}
}
