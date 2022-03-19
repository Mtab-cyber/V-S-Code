package Recursion;

public class Target_sum_subarray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int tar  = 8;
        printTSS(arr,0,0,tar,"");
    }

    private static void printTSS(int[] arr, int i, int sum, int tar, String out) {
        if(i == arr.length){
            if(sum == tar){
                System.out.println(out);
            }
            return;
        }

        printTSS(arr, i+1, sum+arr[i], tar, out+" "+arr[i]);
        printTSS(arr, i+1, sum, tar, out);
    }
}
