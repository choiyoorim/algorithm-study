import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1010 {
    public static void main(String[] args) throws IOException {
        int[][] dp = new int[31][31];
        for(int i = 0; i<=30; i++){
            dp[i][i] = 1; // i개 중 i개를 뽑는
            dp[i][1] = i; // i개 중 1개를 뽑는
            dp[i][0] = 1; // i개 중 0개를 뽑는
        }

        for(int i = 1; i<=30; i++){
            for(int j = 1; j<i; j++){
                dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i<tc; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            System.out.println(dp[M][N]);
        }
    }
}
