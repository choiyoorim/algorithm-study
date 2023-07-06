import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] array = new int[N+1][N+1];
        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int k = 1; k<=N; k++){
                array[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] sumArray = new int[N+1][N+1];
        for(int i = 1; i<=N; i++){
            for(int k = 1; k<=N; k++){
                sumArray[i][k] = sumArray[i-1][k] + sumArray[i][k-1] - sumArray[i-1][k-1] + array[i][k];
            }
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            System.out.println(sumArray[x2][y2] - sumArray[x1-1][y2] - sumArray[x2][y1-1] + sumArray[x1-1][y1-1]);
        }
    }
}
