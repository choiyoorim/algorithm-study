import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1414 {
    static int[][] edges;
    static PriorityQueue<Edge> edgesList;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        edges = new int[N][N];
        edgesList = new PriorityQueue<>();
        int sum = 0;
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char sts[] = st.nextToken().toCharArray();
            for(int j = 0; j<N; j++){
                int temp = 0;
                if(sts[j] >= 'a' && sts[j] <='z'){
                    temp = sts[j] -'a' + 1;
                }
                else if(sts[j] >= 'A' && sts[j] <= 'Z'){
                    temp = sts[j] - 'A' + 27;
                }
                sum += temp;
                edges[i][j] = temp;


                if(i != j && temp != 0){
                    edgesList.add(new Edge(i, j, temp));
                }
            }
        }

        parent = new int[N];
        for(int i = 0; i<N; i++){
            parent[i] = i;
        }

        int count = 0;
        int result = 0;
        while(!edgesList.isEmpty()){
            Edge now = edgesList.poll();
            if(find(now.s) != find(now.e)){
                union(now.s, now.e);
                result += now.w;
                count++;
            }
        }

        if(count == N - 1){
            System.out.println(sum - result);
        }
        else System.out.println(-1);

    }

    public static int find(int a){
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }
}

class Edge implements Comparable<Edge> {
    int s, e, w;
    Edge(int s, int e, int w){
        this.s = s;
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return this.w - o.w;
    }
}