package Recursion;
import java.util.*;

public class SubSequence {
    public static void main(String[] args) {
        String str = (new Scanner(System.in)).nextLine();
        ArrayList<String> arr = getSubSequence(str);
        System.out.println(arr);
    }

    private static ArrayList<String> getSubSequence(String str) {
        if(str.length() == 0){
            ArrayList<String> arr = new ArrayList<>();
            arr.add("");
            return arr;
        }

        char ch = str.charAt(0);
        ArrayList<String> res = getSubSequence(str.substring(1));
        ArrayList<String> ret = new ArrayList<>();

        for(String i : res){
            ret.add(""+i);
            ret.add(ch+i);
        }
        return ret;
    }
}
