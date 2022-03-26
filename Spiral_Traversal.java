import java.io.IOException;

public class Spiral_Traversal {
    public static void main(String[] args)throws IOException {
        int[][] arr = Wave_Traversal.input();
        int n = arr.length;
        int m = arr[0].length;

        int n1 = -1, m1 = -1, n2 = n, m2 = m;
        int i = 0, j = 0;
        char d = 'D';

        while((i <= n2 && i > n1) && (j < m2 && j > m1)){
            System.out.print(arr[i][j]+" ");
            if(d == 'D'){
                i++;
            }
            else if(d == 'R'){
                j++;
            }
            else if(d == 'U'){
                i--;
            }
            else if(d == 'L'){
                j--;
            }
            if(j == m1){
                j++;
                d = 'D';
                m1++;
            }
            if(j == m2){
                j--;
                d = 'U';
                m2--;
            }
            if(i == n1){
                i++;
                d = 'R';
                n1++;
            }
            if(i == n2){
                i--;
                d = 'L';
                n2--;
            }
        }
    }
}
