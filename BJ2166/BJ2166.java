import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] x = new long[N+1];
        long[] y = new long[N+1];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }

        x[N] = x[0];
        y[N] = y[0];

        double result = 0;
        for(int i = 0; i<N; i++){
            result += (x[i] * y[i+1]) - (x[i+1] * y[i]);
        }

        String answer = String.format("%.1f", Math.abs(result)/2.0);
        System.out.println(answer);

        answer.substring(0,2);
        String[] s ={"commang","ddd"};
        for(String str : s){

        }
    }
}
