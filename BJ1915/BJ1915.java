import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long D[][] = new long[N+1][M+1];
        long max = 0;
        for(int i = 0; i<N; i++){
            String s = br.readLine();
            for(int j = 0; j<M; j++){
                D[i][j] = Long.parseLong(s.substring(j,j+1));
                if(D[i][j] == 1 && i>0 && j>0){
                    D[i][j] = Math.min(D[i-1][j-1], Math.min(D[i-1][j], D[i][j-1])) + D[i][j];
                }
                if(D[i][j] > max){
                    max = D[i][j];
                }
            }
        }

        System.out.println(max * max);
    }
}
