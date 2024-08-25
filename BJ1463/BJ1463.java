import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1463 {
    static int[] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        D = new int[N+2];

        for(int i = 0; i<=N; i++){
            D[i] = -1;
        }
        D[1] = 0;

        f(N);
//        for(int i=2; i<N+1; i++){
//            D[i] = D[i-1] + 1;
//            if(i % 2 == 0) {
//                D[i] = Math.min(D[i], D[i/2] + 1);
//            }
//            if(i % 3 == 0){
//                D[i] = Math.min(D[i], D[i/3] + 1);
//            }
//        }

        System.out.println(D[N]);
    }

    static int f(int N){
        if(D[N] != -1) return D[N];

        D[N] = f(N-1) + 1;
        if(N % 2 == 0){
            D[N] = Math.min(D[N], D[N/2] + 1);
        }
        if(N % 3 == 0){
            D[N] = Math.min(D[N], D[N/3] + 1);
        }
        return D[N];
    }
}
