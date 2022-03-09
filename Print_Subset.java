package Problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Print_Subset {

	public static ArrayList<List<Integer>> curr_sub = new ArrayList<List<Integer>>();
	
	public static void sub_set(int[] ar, int i, List<Integer> li) {
		if(i==ar.length) {
			curr_sub.add(li);
			return ;
		}
		li.add(ar[i]);
		//System.out.print(li.get(li.size()-1)+" ");
		sub_set(ar,i+1,li);
		li.remove(li.size()-1);
		sub_set(ar,i+1,li);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int[] ar = {1,2,3};
			List<Integer> temp = new LinkedList<Integer>();
			sub_set(ar,0,temp);
			System.out.println(curr_sub.size());
			for(int i = 0; i < curr_sub.size();i++)
			{
				for(int j : curr_sub.get(i)) {
					System.out.print(j+" ");
				}
				System.out.println();
			}
	}

}

