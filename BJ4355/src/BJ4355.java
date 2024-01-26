import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ4355 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long result;

        while(N!=0){
            result = N;
            if(N == 1){
                result = 0;
            }
            for(int i = 2; i <= Math.sqrt(N); i++){
                if(N % i == 0){
                    result = result - result / i;
                    while(N % i == 0){
                        N /= i;
                    }
                }
            }
            if(N > 1){
                result = result - result / N;
            }
            System.out.println(result);
            st = new StringTokenizer(br.readLine());
            N = Long.parseLong(st.nextToken());
        }

    }
}
