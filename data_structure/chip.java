package data_structure;
import java.util.Scanner;

public class chip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-->0){
            int x = scan.nextInt();
            int y = scan.nextInt();
            if(x == 0 && y == 0){
                System.out.println("0");
            }
            else{
                double d = Math.pow(x,2) + Math.pow(y, 2);
                int r = (int)Math.sqrt(d);
                if(r*r == d){
                    System.out.println("1");
                }
                else{
                    System.out.println("2");
                }
            }
        }
    }
}
