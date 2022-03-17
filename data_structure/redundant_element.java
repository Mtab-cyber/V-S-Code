
import java.util.HashMap;
import java.util.LinkedHashMap;

public class redundant_element {
	public static void main(String[] args) {
		int[] ar = {1};
		int n = ar.length;
		
		HashMap<Integer,Integer> hm = new LinkedHashMap<Integer,Integer>();
		
		for(int i = 0; i < n; i++) {
			if(hm.containsKey(ar[i])) {
				hm.replace(ar[i], hm.get(ar[i]) + 1);
			}
			else {
				hm.put(ar[i], 1);
			}
		}
		
		for(int i : hm.keySet()) {
			if(hm.get(i) > 1) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
	}
}
