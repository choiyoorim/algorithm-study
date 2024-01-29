import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1033 {
    static ArrayList<Node>[] A;
    static long lcm;
    static boolean visited[];
    static long D[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        A = new ArrayList[N];
        D = new long[N];
        visited = new boolean[N];
        for(int i = 0; i<N; i++){
            A[i] = new ArrayList<>();
        }
        lcm = 1;
        for(int i = 0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            A[a].add(new Node(b,p,q));
            A[b].add(new Node(a,q,p));
            lcm *= (p * q / gcd(p,q));
        }
        D[0] = lcm;
        DFS(0);
        long mgcd = D[0];
        for(int i = 1; i<N; i++){
            mgcd = gcd(mgcd,D[i]);
        }
        for(int i = 0; i<N; i++){
            System.out.print(D[i] / mgcd + " ");
        }

    }
    public static long gcd(long a, long b){
        if(b == 0) return a;
        else return gcd(b, a%b);
    }

    public static void DFS(int Node){
        visited[Node] = true;
        for(Node i : A[Node]){
            int next = i.getB();
            if(!visited[next]){
                D[next] = D[Node] * i.getQ() / i.getP();
                DFS(next);
            }
        }
    }
}


class Node{
    int b, p, q;
    public Node(int b, int p, int q){
        super();
        this.b = b;
        this.p = p;
        this.q = q;
    }

    public int getB(){
        return b;
    }

    public int getP(){
        return p;
    }

    public int getQ(){
        return q;
    }
}
