import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] D = new long[N+2][10];

        for(int i = 1; i<=9; i++){
            D[1][i] = 1;
        }

        int MOD = 1000000000;
        for(int i = 2; i<=N; i++){
            for(int j = 0; j<=9; j++){
                if(j == 0){
                    D[i][j] = D[i-1][j+1];
                }
                else if(j == 9){
                    D[i][j] = D[i-1][j-1];
                }
                else{
                    D[i][j] = ( D[i-1][j-1] + D[i-1][j+1] ) % MOD;
                }
            }
        }

        long sum = 0;
        for(int i = 0; i<=9; i++){
            sum = (sum + D[N][i]) % MOD;
        }

        System.out.println(sum);
    }
}
