import java.io.*;
import java.util.*;

public class BJ1854 {
    public static final int INF = 1001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] w = new int[N+1][N+1];
        PriorityQueue<Integer>[] distQueue=new PriorityQueue[N+1];
        Comparator<Integer> cp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1;
            }
        };
        for(int i = 1; i<=N; i++){
            distQueue[i] = new PriorityQueue<>(K, cp);
        }
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            w[a][b] = c;
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1,0));
        distQueue[1].add(0);

        while (!queue.isEmpty()){
            Node now = queue.poll();
            for(int adjNode = 1; adjNode<=N; adjNode++){
                if(w[now.target][adjNode] != 0){
                    if(distQueue[adjNode].size() < K){
                        distQueue[adjNode].add(now.weight + w[now.target][adjNode]);
                        queue.add(new Node(adjNode, now.weight + w[now.target][adjNode]));
                    }
                    else if(distQueue[adjNode].peek() > now.weight + w[now.target][adjNode]){
                        distQueue[adjNode].poll();
                        distQueue[adjNode].add(now.weight + w[now.target][adjNode]);
                        queue.add(new Node(adjNode, now.weight + w[now.target][adjNode]));
                    }
                }

            }
        }

        for(int i = 1; i<=N; i++){
            if(distQueue[i].size() == K){
                bw.write(distQueue[i].peek() + " \n");
            }
            else{
                bw.write(-1 + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}

class Node implements Comparable<Node>{
    int target, weight;
    public Node(int target,int weight){
        this.target = target;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node o) {
        if(this.weight > o.weight) return 1;
        else return -1;
    }
}