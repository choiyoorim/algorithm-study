import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11049 {
    static int[][] D;
    static int[] row;
    static int[] col;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        row = new int[N+1];
        col = new int[N+1];
        D = new int[N+1][N+1];

        StringTokenizer st;
        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            row[i] = Integer.parseInt(st.nextToken());
            col[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<=N; i++){
            for(int j = 0; j<=N; j++){
                D[i][j] = -1;
            }
        }

        System.out.println(DP(1,N));
    }

    public static int DP(int x, int y){
        int result = Integer.MAX_VALUE;
        if(D[x][y] != -1){
            return D[x][y];
        }
        else if(x == y){
            return 0;
        }
        else if(x + 1 == y){
            return row[x] * row[y] * col[y];
        }

        for(int i = x; i<y; i++){
            result = Math.min(result, DP(x,i) + DP(i+1, y) + row[x] * col[i] * col[y]);
        }
        return D[x][y] = result;
    }
}
