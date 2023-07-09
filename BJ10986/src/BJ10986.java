import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long count = 0;
        long[] S = new long[N+1];
        long[] C = new long[M];
        st = new StringTokenizer(bf.readLine());
//        S[0] = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= N; i++){
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i<=N; i++){
            int remainder = (int) (S[i] % M);
            if(remainder == 0) count++;
            C[remainder]++;
        }

        for(int i = 0; i<M; i++){
            if(C[i] > 1){
                count += (C[i] * (C[i] -1) / 2);
            }
        }

        System.out.println(count);
    }
}
