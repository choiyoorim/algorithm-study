import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1012 {
    static int N,M;
    static int[][] A;
    static boolean visited[][];
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        List<Integer> answerList = new ArrayList<>();
        for(int i = 0; i<count; i++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            A = new int[N][M];
            visited = new boolean[N][M];
            int answer = 0;
            for(int k = 0; k<S; k++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                A[a][b] = 1;
            }


            for(int c = 0; c<N; c++){
                for(int d = 0; d<M; d++){
                    if(A[c][d] == 1 && !visited[c][d]){
                        answer++;
                        bfs(c,d);
                    }
                }
            }

//            System.out.println(A[4][0]);
//            for(int f=0; f<N; f++){
//                for(int j = 0; j<M; j++){
//                    System.out.print(A[f][j] + " ");
//                }
//                System.out.println();
//            }

            answerList.add(answer);
        }

        for(int i : answerList){
            System.out.println(i + " ");
        }
    }

    static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i = 0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx >= 0 && ny >= 0 && nx<N && ny<M){
                    if(!visited[nx][ny] && A[nx][ny] == 1){
                        visited[nx][ny] = true;
                        A[nx][ny] = 2;
                        queue.add(new int[] {nx,ny});
                    }
                }
            }
        }
    }
}
