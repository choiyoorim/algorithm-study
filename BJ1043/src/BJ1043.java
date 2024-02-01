import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1043 {
    public static int[] parent;
    public static ArrayList<Integer>[] party;
    public static int[] truep;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N은 사람의 수, M은 파티의 수, T는 진실을 아는 사람의 수
        int N, M, T;
        int result = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        truep = new int[T];
        for(int i = 0; i<T; i++){
            truep[i] = Integer.parseInt(st.nextToken());
        }

        parent = new int[N+1];
        for(int i = 1; i<=N; i++){
            parent[i] = i;
        }

        party = new ArrayList[M];
        for(int i = 0; i<M; i++){
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());
            for(int j = 0; j<partySize; j++){
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 0; i<M; i++){
            int parentNode = party[i].get(0);
            for(int j = 1; j < party[i].size(); j++){
                union(parentNode, party[i].get(j));
            }
        }

        for(int i = 0; i<M; i++){
            boolean isPossible = true;
            int cur = party[i].get(0);
            for(int j = 0; j< truep.length; j++){
                if(find(cur) == find(truep[j])) {
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) result++;
        }

        System.out.println(result);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b) parent[b] = a;
    }

    public static int find(int a){
        if(parent[a] == a) return a;
        else {
            return parent[a] = find(parent[a]);
        }
    }
}
