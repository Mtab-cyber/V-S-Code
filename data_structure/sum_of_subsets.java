
package data_structure;

import java.util.LinkedList;
import java.util.List;

public class sum_of_subsets {
	public static List<Integer> li = new LinkedList<Integer>();
	
	public static void sum(int[] ar, int sum, int i) {
		if(i==ar.length) {
			li.add(sum);
			return ;
		}
		sum(ar,sum+ar[i],i+1);
		sum(ar,sum,i+1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int[] ar = {1,2,3};
			sum(ar,0,0);
			for(int i : li) {
				System.out.print(i+" ");
			}
	}

}
