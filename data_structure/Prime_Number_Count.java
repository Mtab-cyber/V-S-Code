
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'luckyNumbers' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. LONG_INTEGER a
     *  2. LONG_INTEGER b
     */

    public static long luckyNumbers(long a, long b) {
    // Write your code here
        Hashtable<Long,Boolean> prime = new Hashtable<Long,Boolean>();
        long count = 0;
        prime.put((long) 0, false);
        prime.put((long) 1, false);
        while(a <= b){
            long temp = a;
            long sum = 0;
            long ssum = 0;
            while(temp != 0){
                sum += temp%10;
                ssum += Math.pow(temp%10,2);
                temp/=10;
            }
            if(!prime.containsKey(sum)) {
            	int temps = 0;
                for(long i = 2; i < sum; i++){
                    if(sum % i == 0){
                        temps = 1;
                        break;
                    }
                }
                if(temps == 0) {
                	prime.put(sum, true);
                }
                else
                	prime.put(sum, false);
            }
            
            if(!prime.containsKey(ssum)) {
            	int temps = 0;
                for(long i = 2; i < ssum; i++){
                    if(ssum % i == 0){
                        temps = 1;
                        break;
                    }
                }
                if(temps == 0) {
                	prime.put(ssum, true);
                }
                else
                	prime.put(ssum, false);
            }
            
            if(prime.get(sum) && prime.get(ssum)) {
            	count++;
            }
            
            a++;
        }
    return count;
    }

}

public class Prime_Number_Count {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                long a = Long.parseLong(firstMultipleInput[0]);

                long b = Long.parseLong(firstMultipleInput[1]);

                long result = Result.luckyNumbers(a, b);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
