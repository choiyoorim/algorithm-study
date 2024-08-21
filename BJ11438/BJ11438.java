import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ11438 {
    static ArrayList<Integer>[] tree;
    static int[][] parents;
    static int[] depths;
    static boolean[] visited;
    static int kmax;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        tree = new ArrayList[N+1];

        for(int i = 0; i<=N; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        int temp = 1;
        kmax = 0;
        while(temp<=N){
            temp <<= 1;
            kmax++;
        }

        parents = new int[kmax+1][N+1];
        depths = new int[N+1];
        visited = new boolean[N+1];

        BFS(1);

        for(int i = 1; i<=kmax; i++){
            for(int j = 1; j<=N; j++){
                parents[i][j] = parents[i - 1][parents[i-1][j]];
            }
        }

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(findParents(a,b));
        }
    }

    private static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int depth = 1;
        int count = 0;
        int now_size = 1;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int next : tree[now]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                    parents[0][next] = now;
                    depths[next] = depth;
                }
            }
            count++;
            if(count == now_size){
                count = 0;
                now_size = queue.size();
                depth++;
            }
        }
    }

    private static int findParents(int a, int b){
        if(depths[a]>depths[b]){
            int temp = a;
            a = b;
            b = temp;
        }
        for(int k = kmax; k>=0; k--){
            if(Math.pow(2, k) <= depths[b] - depths[a]){
                if(depths[a] <= depths[parents[k][b]]){
                    b = parents[k][b];
                }
            }
        }
        for(int k = kmax; k>=0; k--){
            if(parents[k][a] != parents[k][b]){
                a = parents[k][a];
                b = parents[k][b];
            }
        }

        int LCA = a;
        if(a!=b){
            LCA = parents[0][LCA];
        }
        return LCA;
    }
}
