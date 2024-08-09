import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ11725 {
    static int[] answer;
    static boolean[] visited;
    static ArrayList<Integer>[] arrayLists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arrayLists = new ArrayList[N+1];
        for(int i = 0; i<=N; i++){
            arrayLists[i] =  new ArrayList<>();
        }
        for(int i = 0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arrayLists[s].add(e);
            arrayLists[e].add(s);
        }

        answer = new int[N+1];
        visited = new boolean[N+1];

        DFS(1);

        for(int i = 2; i<=N; i++){
            System.out.println(answer[i]);
        }
    }

    public static void DFS(int i){
        visited[i] = true;
        for(int k : arrayLists[i]){
            if(!visited[k]){
                answer[k] = i;
                DFS(k);
            }
        }
    }
}
