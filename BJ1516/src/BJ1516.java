import java.awt.color.ICC_ColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        ArrayList<Node>[] graph = new ArrayList[N+1];
        int[] timeList = new int[N+1];
        int[] indegree = new int[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            Node newNode = new Node(i, time);
            timeList[i] = time;
            while(true){
                int a = Integer.parseInt(st.nextToken());
                if(a==-1) break;
                else {
                    indegree[i]++;
                    graph[a].add(newNode);
                }
            }
        }

        Queue<Integer> queue = new LinkedList();

        for(int i = 1; i<=N; i++){
            if(indegree[i] == 0) queue.offer(i);
        }

        int[] result = new int[N+1];
        while(!queue.isEmpty()){
            int a = queue.poll();
            for(Node node : graph[a]){
                indegree[node.num]--;
                result[node.num] = Math.max(result[node.num], timeList[a] + result[a]);
                if(indegree[node.num] == 0){
                    queue.offer(node.num);
                }
            }
        }

        for(int i = 1; i<=N; i++){
            result[i] = result[i] + timeList[i];
            System.out.print(result[i] + " ");
        }
    }
}

class Node{
    int num, time;

    public Node(int num, int time){
        this.num = num;
        this.time = time;
    }

    public int getNum(){
        return num;
    }
    public int getTime(){
        return time;
    }
}
