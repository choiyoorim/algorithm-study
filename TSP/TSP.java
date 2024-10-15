import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TSP {
    static int N;
    static int[][] W;
    static int[][] D;
    static final int INF = 16 * 1000000 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[16][16];
        D = new int[16][1<<16];

        StringTokenizer st;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(tspfunc(0, 1));
    }

    private static int tspfunc(int c, int v){
        if(v == (1<<N) -1){
            return W[c][0] == 0 ? INF : W[c][0];
        }
        if(D[c][v] != 0){
            return D[c][v];
        }
        int minVal = INF;
        for(int i = 0; i<N; i++){
            if((v & (1 << i)) == 0 && W[c][i] != 0){
                minVal = Math.min(minVal, tspfunc(i, v|(1<<i)) + W[c][i]);
            }
        }
        D[c][v] = minVal;
        return D[c][v];
    }
}
