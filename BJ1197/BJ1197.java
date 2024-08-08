import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1197 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V, E;
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for(int i = 0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            edges.add(new Edge(s, e, v));
        }

        parent = new int[V+1];
        for(int i = 1; i<=V; i++){
            parent[i] = i;
        }

        int count = 0;
        int sum = 0;
        while(count < V-1){
            Edge edge = edges.poll();
            if(find(edge.e) != find(edge.s)) {
                union(edge.e, edge.s);
                sum += edge.w;
                count++;
            }
        }

        System.out.println(sum);
    }

    public static int find(int a){
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
        }
    }
}

class Edge implements Comparable<Edge>{
    int s, e, w;
    Edge(int s, int e, int w){
        this.s = s;
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        if(this.w > o.w) return 1;
        else return -1;
    }
}
