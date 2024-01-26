import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11689 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long result = N;
        for(long p=2; p <= Math.sqrt(N); p++){
            if(N % p == 0){
                result = result - result / p;
                while(N % p == 0){
                    N /= p;
                }
            }
        }
        if(N > 1) result = result - result / N;
        System.out.println(result);
    }
}
