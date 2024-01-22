import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ13023 {
    static boolean[] visited;
    static ArrayList<Integer>[] friends;
    static boolean arrive;
    public static void main(String[] args) throws IOException {
        int N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        friends = new ArrayList[N];
        int depth = 0;

        for(int i = 0; i<N; i++){
            visited[i] = false;
            friends[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            friends[s].add(e);
            friends[e].add(s);
        }

        for(int i = 0; i<N; i++){
            if(!visited[i]){
                dfs(i,1);
            }
        }

        if(arrive) System.out.println(1);
        else System.out.println(0);
    }

    static void dfs(int v, int depth){
        if(visited[v]) return;
        visited[v] = true;

        if(depth==5){
            arrive = true;
            return;
        }

        for(int a : friends[v]){
            if(!visited[a]) {
                dfs(a,depth+1);
            }
        }
        visited[v] = false;
    }
}
