package data_structure;
public class Flip_Bits {
	public static int flipBits(int[] arr,int n) {
        //Write your code here
        int totalone = 0;
        int curr_sum = 0;
        int max_sum = 0;

        for(int i = 0; i < n; i++){
            int val = 0;
            if(arr[i] == 1){
                totalone++;
                val = -1;
            }
            else{
                val = 1;
            }
            curr_sum = Math.max(val, val+curr_sum);
            max_sum = Math.max(curr_sum, max_sum);
        }

		max_sum = Math.max(0,max_sum);
        return max_sum + totalone;
	}
}
