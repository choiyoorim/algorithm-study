import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1260 {
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        A = new ArrayList[N+1];
        for(int i = 1; i<=N; i++){
            A[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A[S].add(E);
            A[E].add(S);
        }
        for(int i = 1; i<N+1; i++){
            Collections.sort(A[i]);
        }
        DFS(V);
        System.out.println();
        visited = new boolean[N+1];
        BFS(V);
        System.out.println();
    }

    static void DFS(int V){
        visited[V] = true;
        System.out.print(V + " ");
        for(int i : A[V]){
            if(!visited[i]) DFS(i);
        }
    }

    static void BFS(int V){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(V);
        visited[V] = true;

        while(!queue.isEmpty()){
            int nownode = queue.poll();
            System.out.print(nownode + " ");
            for(int i : A[nownode]){
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
