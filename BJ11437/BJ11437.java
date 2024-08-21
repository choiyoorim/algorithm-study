import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ11437 {
    static ArrayList<Integer>[] tree;
    static int[] parents;
    static boolean[] visited;
    static int[] depths;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        for(int i = 0 ; i<=N; i++){
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        parents = new int[N+1];
        depths = new int[N+1];
        visited = new boolean[N+1];
        BFS(1);


        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(findParents(a, b));
        }

    }
    private static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;
        int depth = 1;
        int count = 0;
        int now_size = 1;
        while (!queue.isEmpty()){
            int node = queue.poll();
            for(int i : tree[node]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                    parents[i] = node;
                    depths[i] = depth;
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
        if(depths[a] < depths[b]){
            int temp = a;
            a = b;
            b = temp;
        }
        while(depths[a] != depths[b]){
            a = parents[a];
        }
        while(a != b){
            a = parents[a];
            b = parents[b];
        }

        return a;
    }
}
