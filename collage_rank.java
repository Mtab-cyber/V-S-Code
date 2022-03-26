
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class collage_rank {
  

    static int c1 = 0;
    static int c2 = 0;
    static int c3 = 0;

    static class studentDetail{
        double percentage;
        Map<Integer,Integer> pri = new TreeMap<>();
        studentDetail(double percentage, Map<Integer,Integer> pri){
            this.percentage = percentage;
            this.pri = pri;
        }
    }

    public static void main(String[] args)throws IOException {
      try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int college = Integer.parseInt(temp[0]);
        int student_count = Integer.parseInt(temp[1]);
        int[] seat = new int[college];
        int[] orginal = new int[college];
        String in2[] = br.readLine().split(" ");
        int i = 0;
        for(String inp : in2){
            seat[i] = Integer.parseInt(inp);
            i++;
        }
        i=0;
        Map<Integer,studentDetail> map = new TreeMap<>();
        Map<Double,List<studentDetail>> pref = new TreeMap<>();
        for(i = 0; i < student_count; i++){
            String[] in3 = br.readLine().split(",");
            Map<Integer,Integer> pri = new TreeMap<>();
            for(int j = 2; j < in3.length; j++){
                pri.put(j-1,Integer.parseInt(in3[j].substring(in3[j].length()-1)));
            }
            studentDetail std = new studentDetail(Double.parseDouble(in3[1]),pri);
            double perc = Double.parseDouble(in3[1]);
            map.put(Integer.parseInt(in3[0].substring(in3[0].length()-1,in3[0].length())), std);
            if(pref.containsKey(perc)){
                pref.get(perc).add(std);
            }
            else{
                List<studentDetail> ll = new LinkedList<>();
                ll.add(std);
                pref.put(perc, ll);
            }
        }
        i=0;

        // for(int j : map.keySet()){
        //     System.out.println(j+" "+map.get(j).percentage+" "+map.get(j).pri);
        // }

        double ans[] = new double[college];
        int ansin = 0;
        Set<Double> set = pref.keySet();
        double[] ef = new double[set.size()];
        int l = 0;
        for(double d: set){
            ef[l++] = d;
        }
        Arrays.sort(ef);

        int reb = 0;
        int last = ef.length-1;

        while(reb < last){
            double swap = ef[reb];
            ef[reb] = ef[last];
            ef[last] = swap;
            reb++;
            last--;
        }

        for(Double d : ef){
            //System.out.println(d);
            List<studentDetail> std = pref.get(d);
            ansin = 0;
            for(studentDetail det : std){
                for(int check : det.pri.keySet()){
                    if(ansin == 1)
                        continue;
                    int college_need = det.pri.get(check);
                    if(seat[college_need-1] > 0){
                        ans[college_need-1] = det.percentage;
                        seat[college_need-1]--;
                        ansin =1;
                    }
                }
            }
        }

        i = 1;

        for(double d : ans){
            if(d==0){
                System.out.println("C-"+i+" n\\a");
                i++;
                continue;
            }
            System.out.println("C-"+i+" "+d);
            i++;
        }

        // Arrays.stream(ans).forEach(e -> {
        //     System.out.println("C-"+i+" "+e);
        // });

      }
      catch(Exception e){
        return;
      }

    }
}
