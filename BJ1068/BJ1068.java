import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1068 {
    static ArrayList<Integer>[] arrayLists;
    static boolean[] visited;
    static int root;
    static int deleteNode;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        arrayLists = new ArrayList[N];
        for(int i = 0; i<N; i++){
            arrayLists[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            int a = Integer.parseInt(st.nextToken());
            if(a == -1) root = i;
            else {
                arrayLists[i].add(a);
                arrayLists[a].add(i);
            }
        }
        deleteNode = Integer.parseInt(br.readLine());

        if(deleteNode != root){
            DFS(root);
            System.out.println(answer);
        }
        else {
            System.out.println("0");
        }
    }

    public static void DFS(int i){
        visited[i] = true;
        int children = 0;
        for(int k : arrayLists[i]){
            if(!visited[k] && k != deleteNode) {
                children++;
                DFS(k);
            }
        }

        if(children == 0) answer++;
    }
}
