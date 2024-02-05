import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V, E;
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] graph = new ArrayList[V+1];
        boolean[] visited = new boolean[V+1];
        int[] route = new int[V+1];
        PriorityQueue<Node> queue = new PriorityQueue<>();

        for(int i = 1; i<=V; i++){
            graph[i] = new ArrayList<>();
            route[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a, b, c;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b,c));
        }

        route[start] = 0;
        queue.add(new Node(start,0));
        while(!queue.isEmpty()){
            Node now = queue.poll();
            int nowNode = now.target;
            if(visited[nowNode]) continue;
            visited[nowNode] = true;
            for(Node next : graph[nowNode]){
                int nextNode = next.target;
                int nextWeight = next.weight;
                if(route[nowNode] + nextWeight < route[nextNode]){
                    route[nextNode] = route[nowNode] + nextWeight;
                    queue.add(new Node(nextNode, route[nextNode]));
                }
            }
        }
        for(int i = 1; i<=V; i++){
            if(visited[i]) System.out.println(route[i]);
            else System.out.println("INF");
        }
    }
}

class Node implements Comparable<Node>{
    public int target;
    public int weight;

    public Node(int target,int weight){
        this.target = target;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node node) {
        if(this.weight > node.weight) return 1;
        else return -1;
    }
}
