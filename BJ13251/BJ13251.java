import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int[] lists = new int[M];

        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++){
            lists[i] = Integer.parseInt(st.nextToken());
            sum += lists[i];
        }

        int K = Integer.parseInt(br.readLine());

        double ans = 0.0;
        double[] probs = new double[M];
        for(int i = 0; i<M; i++){
            if(lists[i] >= K){
                probs[i] = 1.0;
                for (int j = 0; j < K; j++) {
                    probs[i] *= (double) (lists[i] - j) / (double) (sum - j);
                }
            }

            ans += probs[i];
        }

        System.out.printf("%.10f", ans);
    }
}
