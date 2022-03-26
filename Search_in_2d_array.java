import java.io.IOException;

public class Search_in_2d_array {
    public static void main(String[] args)throws IOException {
        int[][] arr = Wave_Traversal.input();
        int n = arr.length;
        int m = arr[0].length;
        int k = Input.input_int();

        int r = -1;
        int l = 0;
        int h = n-1;
        while(l <= h){
            int mid = (l+h)/2;
            if(arr[mid][m-1] >= k){
                r = mid;
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }

        if(r == -1){
            System.out.println("Not found");
        }
        else{
            l = 0;
            h = m-1;
            int ans = -1;
            while(l <= h){
                int mid = (l+h)/2;
                if(arr[r][mid] == k){
                    ans = mid;
                    break;
                }
                else if(arr[r][mid] > k){
                    h = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
                System.out.println(r+" "+ans);
            
        }
    }
}
