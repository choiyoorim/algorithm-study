import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] student = new ArrayList[N+1];

        int[] indegree = new int[N+1];

        for(int i = 1; i<=N; i++){
            student[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            student[A].add(B);
            indegree[B]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i<=N; i++){
            if(indegree[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()){
            int target = queue.poll();
            System.out.print(target + " ");
            for(int i : student[target]){
                indegree[i]--;
                if(indegree[i] == 0) queue.offer(i);
            }

        }
    }
}
