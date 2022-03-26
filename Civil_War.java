
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Civil_War{

    public static void main(String[] args) {
        try{
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Deque<Long> de = new LinkedList<Long>();
        long sum = 0;
        long temp = -1;
        for(int i = 0; i < n; i++){
            temp = scan.nextLong();
            if(temp < 0){
                de.addLast(sum);
                de.addLast(temp);
                sum = 0;
            }
            else{
                sum+=temp;
            }
        }

        if(temp >= 0){
            de.addLast(temp);
        }

        long a = 0;
        long b = 0;
        long cnt = 0;
        while(!de.isEmpty()){
            if(cnt%2 == 0){
                long sel = Math.max(de.peekFirst(), de.peekLast());
                if(sel == de.peekLast()){
                    de.pollLast();
                }
                else{
                    de.pollFirst();
                }
                a+=sel;
            }
            else if(cnt%2 == 1){
                long sel = Math.max(de.peekFirst(), de.peekLast());
                if(sel == de.peekLast()){
                    de.pollLast();
                }
                else{
                    de.pollFirst();
                }
                b+=sel;
            }
            cnt++;
        }
        int ans = (int)(Math.abs(a-b));
        
        System.out.print(ans);
    }
    catch(Exception e){
        return;
    }
    }
}