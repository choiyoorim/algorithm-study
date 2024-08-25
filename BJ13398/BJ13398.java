import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int D[] = new int[N+2];
        for(int i = 0; i<N; i++){
            D[i] = Integer.parseInt(st.nextToken());
        }

        int L[] = new int[N+2];
        L[0] = D[0];
        int result = L[0];

        for(int i = 1; i<N; i++){
            L[i] = Math.max(L[i-1] + D[i], D[i]);
            if(result < L[i]) result = L[i];
        }

        int R[] = new int[N+2];
        R[N-1] = D[N-1];
        for(int i = N-2; i>=0; i--){
            R[i] = Math.max(R[i+1] + D[i], D[i]);
        }

        for(int i = 1; i<N-1; i++){
            if(L[i-1] + R[i+1] > result) {
                result = L[i-1] + R[i+1];
            }
        }

        System.out.println(result);


    }
}
