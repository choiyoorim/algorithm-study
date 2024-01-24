import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long Min = Long.parseLong(st.nextToken());
        long Max = Long.parseLong(st.nextToken());
        int sqrt = (int) Math.sqrt(Max);
        boolean[] check = new boolean[(int)(Max-Min+1)];

        for(long i = 2; i <= sqrt; i++){
            long pow = i * i;
            long start = Min / pow;
            if(Min % pow != 0){
                start++;
            }
            for(long j = start; j * pow <= Max; j++){
                check[(int)((j * pow)-Min)] = true;
            }
        }

        int count = 0;
        for(int i = 0; i<= Max - Min; i++){
            if(!check[i]){
                count++;
            }
        }
        System.out.println(count);
    }
}
