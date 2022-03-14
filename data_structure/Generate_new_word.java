
package data_structure;
import java.util.*;

public class Generate_new_word {

    public static class frequency{
        char ch;
        int freq;
        
        void getfrequency(){

        }

        frequency(){

        }
        
        frequency(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }


    public static void main(String[] args){
        try{

            char[] chin = new char[100];

            Scanner scan = new Scanner(System.in);
            String pr = scan.nextLine();
            String in_str = scan.nextLine();

            int count = 0;

            for(int i = 0; i < in_str.length(); i++){
                if(in_str.charAt(i) == ' '){
                    count++;
                }
            }

            String[] input = in_str.split(" ");
            

            Map<Character,Integer> priority = new HashMap<>();

            boolean temp = false;
            for(char ch : pr.toCharArray()){
                if(priority.containsKey(ch)){
                    temp = true;
                    break;
                }
                priority.put(ch, pr.indexOf(ch));
            }
            if(temp){


                System.out.print("New Language Error");


            }
            else{

                StringBuilder sb = new StringBuilder();

                Map<Integer,frequency> freq_pri = new TreeMap<>();
                for(String str : input){
                    str = str.toLowerCase();



                    for(char ch : str.toCharArray()){


                        if(!priority.containsKey(ch))
                        {


                        }
                        else{
                            int temp_pri = priority.get(ch);



                            if(freq_pri.containsKey(temp_pri)){
                                frequency fre = freq_pri.get(temp_pri);
                                fre.freq = fre.freq+1;
                                freq_pri.put(temp_pri, fre);


                            }
                            else{
                                frequency p = new frequency(ch,1);
                                freq_pri.put(priority.get(ch), p);
                            }
                        }
                    }


                    for(int i : freq_pri.keySet()){
                        frequency p = freq_pri.get(i);
                        int freq = p.freq;
                        while(freq-->0){
                            sb.append(p.ch);
                        }
                    }
                    sb.append(" ");
                    freq_pri.clear();
                }

                String result;

                if(sb.charAt(sb.length()-1) == ' '){
                    result = sb.substring(0,sb.length()-1).toString();
                }
                else{
                    result = sb.toString();
                }

                System.out.print(result);

            }
        }
        catch(Exception e){
            return;
        }
    }
}
