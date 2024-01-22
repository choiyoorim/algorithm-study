import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1967 {
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        dist = new int[N+1];
        for(int i = 1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            graph[S].add(new Node(E,W));
            graph[E].add(new Node(S,W));
        }

        bfs(1);
        int maxIndex = 1;
        for(int i = 1; i<=N; i++){
            if(dist[maxIndex] < dist[i]) maxIndex = i;
        }

        dist = new int[N+1];
        visited = new boolean[N+1];
        bfs(maxIndex);


        Arrays.sort(dist);
        System.out.println(dist[N]);
    }

   static void bfs(int start){
       Queue<Node> queue = new LinkedList<>();
       queue.add(new Node(start, 0));
       visited[start] = true;
       dist[start] = 0;

       while(!queue.isEmpty()){
           Node nowNode = queue.poll();
           for(Node node : graph[nowNode.edge]){
               int E = node.edge;
               int W = node.weight;
               if(!visited[E]){
                   visited[E] = true;
                   dist[E] = dist[nowNode.edge] + W;
                   queue.add(new Node(E,W));
               }
           }
       }
   }
}

class Node{
    int edge, weight;
    Node(int e,int w){
        edge = e;
        weight = w;
    }
}