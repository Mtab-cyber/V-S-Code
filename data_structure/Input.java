package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int input_int()throws IOException{
        return Integer.parseInt(br.readLine());
    }
    
    public static double input_double()throws IOException{
        return Double.parseDouble(br.readLine());
    }

    public static char input_char()throws IOException{
        return br.readLine().charAt(0);
    }

    public static long input_long()throws IOException{
        return Long.parseLong(br.readLine());
    }

    public static String input_string()throws IOException{
        return (br.readLine());
    }

    public static int[] input_intarr(char ch)throws IOException{
        String[] str = br.readLine().split(ch+"");
        int[] arr = new int[str.length];
        int i = 0;
        for(String temp : str){
            arr[i++] = Integer.parseInt(temp);
        }
        return arr;
    }
    public static double[] input_doublearr(char ch)throws IOException{
        String[] str = br.readLine().split(ch+"");
        double[] arr = new double[str.length];
        int i = 0;
        for(String temp : str){
            arr[i++] = Double.parseDouble(temp);
        }
        return arr;
    }
    public static long[] input_longarr(char ch)throws IOException{
        String[] str = br.readLine().split(ch+"");
        long[] arr = new long[str.length];
        int i = 0;
        for(String temp : str){
            arr[i++] = Long.parseLong(temp);
        }
        return arr;
    }
    public static char[] input_chararr(char ch)throws IOException{
        String[] str = br.readLine().split(ch+"");
        char[] arr = new char[str.length];
        int i = 0;
        for(String temp : str){
            arr[i++] = temp.charAt(0);
        }
        return arr;
    }
}
