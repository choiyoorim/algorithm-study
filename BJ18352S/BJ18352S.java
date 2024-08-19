import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ18352S {
    static int visited[];
    static ArrayList<Integer>[] graph;
    static int N, M, K, X;
    static ArrayList<Integer> ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i = 0; i<=N; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(B);
        }

        ans = new ArrayList<>();
        visited = new int[N+1];
        for(int i = 0; i<=N; i++){
            visited[i] = -1;
        }

        BFS(X); // 시작도시 설정

        for(int i = 0; i<=N; i++){
            if(visited[i] == K){
               ans.add(i);
            }
        }

        if(ans.isEmpty()){
            System.out.println("-1");
        }
        Collections.sort(ans);
        for(int temp:ans){
            System.out.println(temp);
        }
    }

    public static void BFS(int X){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(X);
        visited[X]++; // 출발 노드를 0으로 설정하는 코드

        while(!queue.isEmpty()) {
            int nowNode = queue.poll();
            for (int i : graph[nowNode]) {
                if (visited[i] == -1) {
                    visited[i] = visited[nowNode] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
