import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20040 {
    public static int[] parent;
    public static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N];
        for(int i = 0; i<N; i++){
            parent[i] = i;
        }
        for(int i = 1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(find(a) == find(b)){
                System.out.println(i);
                return;
            }
            union(a,b);
        }
        System.out.println(0);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }
    public static int find(int a){
        if(a == parent[a]) return a;
        else {
            return parent[a] = find(parent[a]);
        }
    }
}
