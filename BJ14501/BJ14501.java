import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N+1];
        int[] P = new int[N+1];
        int[] D = new int[N+2];

        StringTokenizer st;
        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = N; i>0; i--){
            if(i + T[i] > N+1){
                D[i] = D[i+1];
            }
            else{
                D[i] = Math.max(D[i+T[i]] + P[i], D[i+1]);
            }
        }

        System.out.println(D[1]);
    }
}
