import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1976 {
    public static int[][] adj;
    public static int[] route;
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        adj = new int[N+1][N+1];
        route = new int[M+1];
        parent = new int[N+1];

        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j<=N; j++){
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=M; i++){
            route[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<=N; i++){
            parent[i] = i;
        }

        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                if(adj[i][j] == 1) union(i,j);
            }
        }

        int q = find(route[1]);
        for(int i = 2; i<=M; i++){
            if(q != find(route[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        parent[b] = a;
    }

    public static int find(int a){
        if(parent[a] == a){
            return a;
        }
        else{
            return parent[a] = find(parent[a]);
        }
    }
}
