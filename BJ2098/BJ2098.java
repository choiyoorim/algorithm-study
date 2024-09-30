import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2098 {
    static int N;
    static int[][] W;
    static int[][] D;
    static final int INF = 1000000 * 16 + 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[16][16];
        D = new int[16][1 << 16];
        StringTokenizer st;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 점화식 현재 도시, 이미 방문한 도시 => 남은 도시 경유하는데 드는 최소 비용
        System.out.println(DP(0, 1));
    }


    public static int DP(int current, int visited){
        if(visited == (1 << N) -1){
            return W[current][0] == 0 ? INF : W[current][0];
        }
        if(D[current][visited] != 0){
            return D[current][visited];
        }
        int result = INF;
        for(int i = 0; i<N; i++){
            if((visited & (1 << i))==0 && W[current][i] != 0){
                result = Math.min(result, DP(i, (visited | (1<<i))) + W[current][i]);
            }
        }
        D[current][visited] = result;
        return D[current][visited];
    }
}
