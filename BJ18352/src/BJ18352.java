import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ18352 {
    static int[] visited;
    static ArrayList<Integer>[] road;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        visited = new int[N+1];
        for(int i = 0 ; i<=N; i++){
            visited[i] = -1;
        }

        road = new ArrayList[N+1];
        for(int i = 0; i<N+1; i++){
            road[i] = new ArrayList<>();
        }
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            road[A].add(B);
        }
        BFS(X);
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i<=N; i++){
            if(visited[i] == K) answer.add(i);
        }
        Collections.sort(answer);
        if(answer.isEmpty()) System.out.println(-1);
        else{
            for(int i : answer){
                System.out.println(i);
            };
        }
    }

    public static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start]++;
        while(!queue.isEmpty()){
            int s = queue.poll();
            for(int i : road[s]){
                if(visited[i] == -1){
                    visited[i] = visited[s] + 1;
                    queue.add(i);
                }
            }
        }

    }
}
