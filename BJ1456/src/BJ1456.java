import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1456 {
    public static void main(String[] args) throws IOException {
        long A,B;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        long[] numbers = new long[10000001];
        for(int i = 2; i <= 10000000; i++){
            numbers[i] = i;
        }
        for(int i = 2; i <= Math.sqrt(10000000); i++){
            if(numbers[i] == 0) continue;
            for(int j = i + i; j <= 10000000; j = j + i){
                numbers[j] = 0;
            }
        }
        int count = 0;
        for(int i = 2; i<=10000000; i++){
            if(numbers[i] != 0){
                long temp = numbers[i];
                while((double) numbers[i] <= (double)B/(double)temp){
                    if((double) numbers[i] >= (double)A/(double)temp){
                        count++;
                    }
                    temp = temp * numbers[i];
                }
            }
        }
        System.out.println(count);
    }
}
