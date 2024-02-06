import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1219 {
    static Edge[] edges;
    static long distance[], cityMoney[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, sCity, eCity, M;
        N = Integer.parseInt(st.nextToken());
        sCity = Integer.parseInt(st.nextToken());
        eCity = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new Edge[M];
        distance = new long[N];
        cityMoney = new long[N];

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, money);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            cityMoney[i] = Long.parseLong(st.nextToken());
            distance[i] = Long.MIN_VALUE;
        }

        distance[sCity] = cityMoney[sCity];
        for(int i = 0; i <= N + 100; i++){
            for(int j = 0; j<M; j++){
                Edge edge = edges[j];
                if(distance[edge.start] == Long.MIN_VALUE) continue;
                else if(distance[edge.start] == Long.MAX_VALUE) distance[edge.end] = Long.MAX_VALUE;
                else if(distance[edge.end] < distance[edge.start] + cityMoney[edge.end] - edge.money){
                    distance[edge.end] = distance[edge.start] + cityMoney[edge.end] - edge.money;
                    if(i >= N - 1) distance[edge.end] = Long.MAX_VALUE;
                }

            }
        }

        if(distance[eCity] == Long.MIN_VALUE) System.out.println("gg");
        else if(distance[eCity] == Long.MAX_VALUE) System.out.println("Gee");
        else System.out.println(distance[eCity]);
    }
}

class Edge{
    int start, end, money;
    public Edge(int start, int end, int money){
        this.start = start;
        this.end = end;
        this.money = money;
    }
}
