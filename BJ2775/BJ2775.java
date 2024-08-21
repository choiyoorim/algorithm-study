import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2775 {
    public static void main(String[] args) throws IOException {
        int[][] dp = new int[15][15];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i<15; i++){
            dp[0][i] = i;
            dp[i][1] = 1;
        }

        for(int i = 1; i<15; i++){
            for(int j = 1; j<15; j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        for(int i = 0; i<tc; i++){
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            System.out.println(dp[a][b]);
        }
    }
}
