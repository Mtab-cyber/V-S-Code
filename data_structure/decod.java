
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class decod {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        while(n-->0){
        String str = scan.nextLine();
        List<String> arr = new LinkedList<>();
        int i = 0;
        int j = 0;
        while(j < str.length()){
            if(str.charAt(i) != str.charAt(j)){
                arr.add(str.substring(i,j));
                if(str.charAt(j) == '_'){
                    j++;
                    i = j;
                }
                else{
                    i = j;
                    j++;
                }
            }
            else{
                j++;
            }
        }

        if(j==str.length() && i != j){
            arr.add(str.substring(i,j));
        }

        System.out.println(solve(arr));
    }
}

    private static String solve(List<String> arr) {
        StringBuilder sb = new StringBuilder();

        Map<Integer,char[]> map = new HashMap<>();
        
        char[] a1 = {',','@'};
        char[] a2 = {'A','B','C','a','b','c','2'};
        char[] a3 = {'D','E','F','d','e','f','3'};
        char[] a4 = {'G','H','I','g','h','i','4'};
        char[] a5 = {'J','K','L','j','k','l','5'};
        char[] a6 = {'M','N','O','m','n','o','6'};
        char[] a7 = {'P','Q','R','S','p','q','r','s','7'};
        char[] a8 = {'T','U','V','t','u','v','8'};
        char[] a9 = {'W','X','Y','Z','w','x','y','z','9'};
        char[] a0 = {' ','0'};

        map.put(0,a0);
        map.put(1,a1);
        map.put(2,a2);
        map.put(3,a3);
        map.put(4,a4);
        map.put(5,a5);
        map.put(6,a6);
        map.put(7,a7);
        map.put(8,a8);
        map.put(9,a9);

        for(String str : arr){
            int l = str.length();
            char[] temp = map.get(Integer.parseInt(String.valueOf(str.charAt(0))));
            sb.append(temp[(str.length()-1)%temp.length]);
        }

        System.out.println(sb.toString());
        return "end";
    }
}
