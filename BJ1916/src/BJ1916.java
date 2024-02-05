import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V, E;
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        ArrayList<Node>[] graph = new ArrayList[V+1];
        boolean[] visited = new boolean[V+1];
        int[] distance = new int[V+1];
        for(int i = 1; i<=V; i++){
            graph[i] =  new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        StringTokenizer st;
        for(int i = 0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b,c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        distance[start] = 0;

        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(visited[now.target]) continue;
            visited[now.target] = true;
            for(Node next:graph[now.target]){
                if(distance[now.target] + next.weight < distance[next.target]) {
                    distance[next.target] = distance[now.target] + next.weight;
                    queue.add(new Node(next.target, distance[next.target]));
                }
            }
        }

        System.out.println(distance[end]);
    }
}

class Node implements Comparable<Node>{
    int target, weight;

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
