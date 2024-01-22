import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1167 {
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        dist = new int[n+1];
        for(int i = 1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            while(true){
                int E = Integer.parseInt(st.nextToken());
                if(E == -1) break;
                int W = Integer.parseInt(st.nextToken());
                graph[S].add(new Node(E,W));
            }
        }

        bfs(1);
        int maxIndex=1;
        for(int i = 1; i<=n; i++){
            if(dist[maxIndex]<dist[i]){
                maxIndex = i;
            }
        }

        dist = new int[n+1];
        visited = new boolean[n+1];
        bfs(maxIndex);
        maxIndex = 1;
        for(int i = 1; i<=n; i++){
            if(dist[maxIndex]<dist[i]){
                maxIndex = i;
            }
        }

        System.out.println(dist[maxIndex]);
    }

    public static void bfs(int start){
        Queue<Node> queue = new LinkedList<>();
        visited[start] = true;
        dist[start] = 0;
        queue.add(new Node(start, 0));

        while(!queue.isEmpty()){
            Node nowNode = queue.poll();
            for(Node node:graph[nowNode.arrival]){
                int E = node.arrival;
                int W = node.weight;
                if(!visited[E]){
                    dist[E] = dist[nowNode.arrival] + W;
                    visited[E] = true;
                    queue.add(new Node(E,W));
                }
            }
        }
    }
}

class Node{
    int arrival;
    int weight;
    Node(int E, int W) {
        arrival = E;
        weight = W;
    }
};

