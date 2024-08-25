import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1256 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] D = new int[201][201];

        for(int i = 0; i<201; i++){
            for(int j = 0; j<=i; j++){
                if(j == 0 || i == j) D[i][j] = 1;
                else {
                    D[i][j] = D[i-1][j] + D[i-1][j-1];
                    if(D[i][j] > 1000000000) D[i][j] = 1000000001;
                }
            }
        }

        int sum = N+M;
        if(D[sum][M] < K) System.out.println(-1);
        else {
            int count = sum;
            char[] ans = new char[sum];
            int where = 0;
            while(where < sum){
                count--;
                int T = D[count][M];
                if(T >= K) {
                    ans[where] = 'a';
                }
                else{
                    ans[where] = 'z';
                    M--;
                    K -= T;
                }
                where++;
            }

            System.out.println(ans);
        }

    }

}
