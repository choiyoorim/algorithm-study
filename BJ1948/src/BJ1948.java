import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1948 {
    static ArrayList<Node>[] arrayList,reverseList;
    static int[] indegree;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arrayList = new ArrayList[N+1];
        reverseList = new ArrayList[N+1];
        indegree = new int[N+1];
        for(int i = 1; i<=N; i++){
            arrayList[i] = new ArrayList<Node>();
            reverseList[i] = new ArrayList<Node>();
        }
        for(int i = 1; i<=M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arrayList[a].add(new Node(b,c));
            reverseList[b].add(new Node(a,c));
            indegree[b]++;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int[] result = new int[N+1];
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(Node next:arrayList[now]){
                indegree[next.head]--;
                result[next.head] = Math.max(result[next.head],result[now] + next.time);
                if(indegree[next.head] == 0){
                    queue.add(next.head);
                }
            }
        }

        int resultCount = 0;
        boolean visited[] = new boolean[N+1];
        queue = new LinkedList<>();
        queue.offer(end);
        visited[end] = true;
        while (!queue.isEmpty()){
            int now = queue.poll();
            for(Node next : reverseList[now]){
                if(result[next.head] + next.time == result[now]){
                    resultCount++;
                    if(visited[next.head] == false){
                        visited[next.head] = true;
                        queue.offer(next.head);
                    }
                }

            }
        }
        System.out.println(result[end]);
        System.out.println(resultCount);
    }
}

class Node{
    public int head, time;
    public Node(int head, int time){
        this.head = head;
        this.time = time;
    }
}
