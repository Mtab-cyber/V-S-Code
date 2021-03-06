import java.io.IOError;
import java.io.IOException;

public class Wave_Traversal{

    public static int[][] input()throws IOException{
        int n = Input.input_int();
        int m = Input.input_int();
        int[][] arr = new int[n][];
        for(int i = 0;i < n; i++){
            arr[i] = Input.input_intarr(" ");
        }
        return arr;
    }
    public static void main(String[] args)throws IOException {
        int[][] arr = input();
        int n = arr.length;
        int m = arr[0].length;
        int i = 0, j = 0;
        while(j < m){
            while(i < n && i > -1){
                System.out.print(arr[i][j]+" ");
                if(j%2 == 0){
                    i++;
                }
                else{
                    i--;
                }
            }
            if(j%2 == 0){
                i--;
            }
            else{
                i++;
            }
            j++;
        }
    }
}