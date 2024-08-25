import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int MOD = 1000000000;

        long D[] = new long[N+2];
        D[1] = 0; D[2] = 1;
        for(int i = 3; i<=N; i++){
            D[i] = (i-1) * (D[i-2] + D[i-1]) % MOD;
        }

        System.out.println(D[N]);
    }
}
