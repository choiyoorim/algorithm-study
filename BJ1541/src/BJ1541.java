import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer minusSplit = new StringTokenizer(br.readLine(), "-");
        int sum = Integer.MAX_VALUE;

        while (minusSplit.hasMoreTokens()){
            int temp = 0;

            StringTokenizer plusSplit = new StringTokenizer(minusSplit.nextToken(),"+");
            while(plusSplit.hasMoreTokens()){
                temp += Integer.parseInt(plusSplit.nextToken());
            }
            if(sum == Integer.MAX_VALUE){
                sum = temp;
            }
            else {
                sum -= temp;
            }
        }

        System.out.println(sum);

    }
}
