import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2178 {
    static int N,M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] A;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i<N; i++){
            String line = br.readLine();
            for(int k = 0; k<M; k++){
                A[i][k] = Integer.parseInt(String.valueOf(line.charAt(k)));
            }
        }

        bfs(0,0);
        System.out.println(A[N-1][M-1]);
    }

    static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] newnode = queue.poll();

            for(int i = 0; i<4; i++){
                int nx = newnode[0] + dx[i];
                int ny = newnode[1] + dy[i];
                if(nx>=0 && ny>=0 && nx<N && ny<M){
                    if (!visited[nx][ny] && A[nx][ny] != 0) {
                        visited[nx][ny] = true;
                        A[nx][ny] = A[newnode[0]][newnode[1]] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }

        }

    }
}
