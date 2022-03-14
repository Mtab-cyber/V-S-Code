import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class apur {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long k = scan.nextLong();
        int n = scan.nextInt();
        int [] ar = new int[n];
        for(int i = 0;i  < n; i++){
            ar[i] = scan.nextInt();
        }

        Set<Integer> set = new HashSet<>();
        
        int bt = 0;
        int i = 0;
        int no_item = 0;
        int min_cost = 0;
        int ans = Integer.MAX_VALUE;

        while(i < n){
            //System.out.println(min_cost+" "+ans+" "+no_item);
            if(set.contains(ar[i])){
                i++;
                continue;
            }
            else{
                min_cost += ar[i];
                if(min_cost > k){
                    min_cost -= ar[i];
                    int l = i - bt;
                    if(no_item == l){
                        min_cost = Math.min(min_cost, ans);
                    }
                    else if(l > no_item){
                        l = no_item;
                        ans = min_cost;
                    }
                    set.clear();
                    i = bt+1;
                    bt++;
                    min_cost = 0;
                }
                else{
                    set.add(ar[i]);
                    i++;
                }
            }
        }
        if(i == n && min_cost <= k){
            int l = i - bt;
            if(l == no_item){
                ans = Math.min(min_cost, ans);
            }
            else if(l > no_item){
                no_item = l;
                ans = min_cost;
            }
        }
        System.out.println(no_item+"\n"+ans);
    }
}
