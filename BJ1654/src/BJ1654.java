import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1654 {
    public static void main(String[] args) throws IOException {
        int K, N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        long A[] = new long[K];

        for(int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            A[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(A);

        long start = 1, end = A[K-1];
        long ans = 0;
        while(start <= end){
            long middle = (start + end) / 2;
            int count = 0;
            for(int i = 0; i<K; i++){
                count += A[i] / middle;
            }
            if(count < N){
                end = middle - 1;
            }
            else{
                ans = Math.max(ans,middle);
                start = middle + 1;
            }
        }
        System.out.println(ans);
    }
}
