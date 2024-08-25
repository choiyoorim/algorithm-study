import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Q = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N+1];
        long[] counts = new long[N+1];
        int[] S = new int[N+1];
        counts[0] = 1;
        for(int i = 1; i<=N; i++){
            counts[i] = counts[i-1] * i;
        }

        if(Q == 1){
            long K = Long.parseLong(st.nextToken());
            for(int i = 1; i<=N; i++){
                for(int j = 1, cnt = 1; j<=N; j++){
                    if(visited[j]) continue;

                    if(K <= cnt * counts[N-i]){
                        K -= ((cnt-1) * counts[N-i]);
                        S[i] = j;
                        visited[j] = true;
                        break;
                    }

                    cnt++;
                }
            }

            for(int i = 1; i<=N; i++){
                System.out.print(S[i] + " ");
            }
        }
        else if(Q == 2){
            long K = 1;
            for(int i = 1; i<=N; i++){
                S[i] = Integer.parseInt(st.nextToken());
                long cnt = 0;
                for(int j = 1; j<S[i]; j++){
                    if(visited[j] == false) cnt++;
                }
                K += cnt * counts[N-i];
                visited[S[i]] = true;
            }

            System.out.println(K);
        }
    }
}
