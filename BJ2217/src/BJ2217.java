import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] rope = new int[N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            rope[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(rope);

        int max = 0;
        for(int i = N-1; i>=0; i--){
            if(rope[i] * (N - i) > max) {
                max = rope[i] * (N - i);
            }
        }
        System.out.println(max);
    }
}
