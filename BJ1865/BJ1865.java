import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i<TC; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int edges =  M + W;
            long[] dists = new long[N+1];
            ArrayList<Edge> edgesList = new ArrayList<>();

            for(int j = 0; j<edges; j++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                if(j < M) {
                    edgesList.add(new Edge(s, e, t));
                    edgesList.add(new Edge(e, s, t));
                }
                else edgesList.add(new Edge(s, e, -1 * t));
            }

            for(int k = 1; k<N; k++){
                for(int m = 0; m<edgesList.size(); m++){
                    Edge edge = edgesList.get(m);
                    if(dists[edge.e] > dists[edge.s] + edge.time){
                        dists[edge.e] = dists[edge.s] + edge.time;
                    }
                }
            }

            boolean cycle = false;
            for(int m = 0; m<edgesList.size(); m++){
                Edge edge = edgesList.get(m);
                if(dists[edge.e] > dists[edge.s] + edge.time){
                    cycle = true;
                }
            }

            if(cycle){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}

class Edge{
    int s, e, time;
    Edge(int s, int e, int time){
        this.s = s;
        this.e = e;
        this.time = time;
    }
}
