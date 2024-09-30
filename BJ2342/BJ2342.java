import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ2342 {
    public static void main(String[] args) throws IOException {
        int D[][][] = new int[100001][5][5];
        int[][] dp = {
                {0, 2, 2, 2, 2},
                {2, 1, 3, 4, 3},
                {2, 3, 1, 3, 4},
                {2, 4, 3, 1, 3},
                {2, 3, 4, 3, 1}
        };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = 1;

        for(int i = 0; i<5; i++)
            for(int j = 0; j<5; j++)
                for(int k = 0; k<100001; k++){
                    D[k][i][j] = 100001 * 4;
                }

        D[0][0][0] = 0;
        while(true){
            int num = Integer.parseInt(st.nextToken());
            if(num == 0) break;

            for(int i = 0; i<5; i++){
                if(i == num) continue;
                for(int j = 0; j<5; j++){
                    D[s][i][num] = Math.min(D[s-1][i][j] + dp[j][num], D[s][i][num]);
                }
            }

            for(int j = 0; j<5; j++){
                if(j == num) continue;
                for(int i = 0; i<5; i++){
                    D[s][num][j] = Math.min(D[s-1][i][j] + dp[i][num], D[s][num][j]);
                }
            }

            s++;
        }
        s--;

        int min = Integer.MAX_VALUE;
        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                min = Math.min(min, D[s][i][j]);
            }
        }
        System.out.println(min);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.ge
    }

}
