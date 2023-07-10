import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int max = 0; int sum = 0;
        int[] temp = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++){
            temp[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < K; i++){
            sum += temp[i];
        }
        max = sum;

        for(int p = K; p < N; p++){
            int i = p - K;
            sum += temp[p];
            sum -= temp[i];
            if(sum > max) max = sum;
        }

        System.out.println(max);
    }
}
