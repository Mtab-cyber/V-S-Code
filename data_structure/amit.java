import java.util.*;

public class amit{

   
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scan.nextInt();
        }

        System.out.println(maxSq(arr));
    }

    public static int maxSq(int[] hts) {
        Deque<Integer> stk = new LinkedList<>();
        int i=0, maxArea = 0;

        while (i < hts.length) {
            while (!stk.isEmpty() && hts[i] < hts[stk.peek()]) {
                int idx = stk.pop();
                int width = stk.isEmpty() ? i : i - stk.peek() - 1;
                int edge = Math.min(width, hts[idx]);
                maxArea = Math.max(maxArea, edge * edge);
            }

            stk.push(i++);
        }

        while (!stk.isEmpty()) {
            int idx = stk.pop();
            int width = stk.isEmpty() ? i : i - stk.peek() - 1;
            int edge = Math.min(width, hts[idx]);
            maxArea = Math.max(maxArea, edge * edge);
        }
        return (int)(Math.sqrt(maxArea));
    }
}