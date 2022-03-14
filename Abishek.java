import java.util.*;

public class Abishek{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int q = scan.nextInt();
        int[][] ar = new int[q][2];
        for(int i = 0; i < q; i++){
            ar[i][0] = scan.nextInt();
            ar[i][1] = scan.nextInt();
        }

        Set<Integer> set = new HashSet<>();
        int i = 0;
        while(i < q && ar[i][0] != 1)i++;
        set.add(ar[i][1]);
        i++;
        for(;i<q;i++){
            if(set.contains(ar[i][0])){
                set.add(ar[i][1]);
            }
        }
        System.out.println(set.size());
    }
}