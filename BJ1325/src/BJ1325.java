import java.io.*;
import java.util.*;

public class BJ1325 {
    static int N, M, max;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] answer;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        answer = new int[N+1];

        for(int i = 1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[A].add(B);
        }

        for(int i = 1; i<=N; i++){
            visited = new boolean[N+1];
            BFS(i);
        }

        max = 0;
        for(int i = 1; i<=N; i++){
            if(answer[i] > max) max = answer[i];
        }

        for(int i = 1; i<=N; i++){
            if(answer[i] == max) bw.write(i + " ");
        }
        bw.flush();
        bw.close();
    }

    public static void BFS(int node){
        queue.add(node);
        visited[node] = true;
        while(!queue.isEmpty()){
            int now_node = queue.poll();
            for(int i : list[now_node]){
                if(visited[i] == false){
                    visited[i] = true;
                    answer[i]++;
                    queue.add(i);
                }
            }
        }
    }
}
