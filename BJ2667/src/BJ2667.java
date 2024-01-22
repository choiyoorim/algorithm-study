import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ2667 {
    static int N,count;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void dfs(int x, int y){
        map[x][y] = 0;
        count++;
        for(int i = 0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny]==1){
                dfs(nx,ny);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int result = 0;
        ArrayList<Integer> countList = new ArrayList<>();
        String st;

        for(int i = 0; i<N; i++){
            st = br.readLine();
            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(String.valueOf(st.charAt(j)));
            }
        }

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                count = 0;
                if(map[i][j] == 1) {
                    result++;
                    dfs(i,j);
                    countList.add(count);
                }
            }
        }
        System.out.println(result);
        Collections.sort(countList);
        for(int i : countList){
            System.out.println(i);
        }

    }
}
