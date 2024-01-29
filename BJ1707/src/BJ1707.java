import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1707 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] point;
    static boolean answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            visited = new boolean[V+1];
            point = new int[V+1];
            answer = true;

            A = new ArrayList[V+1];
            for(int j = 1; j<= V; j++){
                A[j] = new ArrayList<>();
            }

            for(int k = 0; k<E; k++){
                st = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                A[m].add(n);
                A[n].add(m);
            }

            for(int l = 1; l<=V; l++){
                if(answer){
                    DFS(l);
                }
                else break;
            }

            if(answer) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static void DFS(int node){
        visited[node] = true;
        for(int i : A[node]){
            if(!visited[i]) {
                point[i] = (point[node] + 1) % 2;
                DFS(i);
            }
            else if(point[node] == point[i]) answer = false;
        }
    }
}
