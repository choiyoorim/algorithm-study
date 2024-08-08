import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj17472 {
    static int N, M, sNum;
    static int[][] maps;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] visited;
    static ArrayList<int[]> mList;
    static ArrayList<ArrayList<int[]>> sumList;
    static PriorityQueue<Edge> queue;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maps = new int[N][M];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        sumList = new ArrayList<>();

        sNum = 1;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(maps[i][j] != 0 && !visited[i][j]){
                    BFS(i, j);
                    sNum++;
                    sumList.add(mList);
                }
            }
        }

        queue = new PriorityQueue<>();
        for(int i = 0; i<sumList.size(); i++){
            ArrayList<int[]> now = sumList.get(i);
            for(int j = 0; j<now.size(); j++){
                int[] temp = now.get(j);
                int nx = temp[0];
                int ny = temp[1];
                int nowSum = maps[nx][ny];

                for(int d = 0; d<4; d++){
                    int tx = dr[d];
                    int ty = dc[d];
                    int length = 0;
                    while(nx + tx >= 0 && nx + tx <N && ny + ty >=0 && ny + ty<M){
                        if(maps[nx+tx][ny+ty] == nowSum) break;
                        else if(maps[nx+tx][ny+ty] != 0){
                            if(length > 1) queue.add(new Edge(nowSum, maps[nx+tx][ny+ty], length));
                            break;
                        }
                        else length++;

                        if(tx<0) tx--;
                        else if(tx>0) tx++;
                        else if(ty<0) ty--;
                        else if(ty>0) ty++;
                    }
                }
            }
        }

        parent = new int[sNum];
        for(int i = 0; i<parent.length; i++){
            parent[i] = i;
        }

        int useEdge = 0;
        int result = 0;
        while(!queue.isEmpty()){
            Edge now = queue.poll();
            if(find(now.s) != find(now.e)){
                union(now.s, now.e);
                result += now.w;
                useEdge++;
            }
        }

        if(useEdge == sNum - 2)
            System.out.println(result);
        else System.out.println(-1);
    }
    public static int find(int a){
        if(a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
        }
    }
    public static void BFS(int a, int b){
        Queue<int[]> queue = new LinkedList<>();
        mList = new ArrayList<>();
        int[] start = {a,b};
        queue.add(start);
        mList.add(start);
        visited[a][b] = true;
        maps[a][b]=sNum;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nx = now[0];
            int ny = now[1];
            for(int d = 0; d<4; d++){
                int dx = dr[d];
                int dy = dc[d];
                while(nx + dx >= 0 && nx + dx<N && ny + dy >= 0 && ny + dy < M){
                    if(maps[nx+dx][ny + dy] != 0 && !visited[nx+dx][ny+dy]){
                        addNode(nx+dx, ny+dy, queue);
                    } else break;
                    if(dx < 0) dx--;
                    else if(dx > 0) dx++;
                    else if(dy<0) dy--;
                    else if(dy>0) dy++;
                }
            }
        }
    }

    public static void addNode(int i, int j, Queue<int[]> queue){
        maps[i][j] = sNum;
        visited[i][j] = true;
        int[] temp = {i,j};
        mList.add(temp);
        queue.add(temp);
    }
}

class Edge implements Comparable<Edge>{
    int s, e, w;
    Edge(int s, int e, int w){
        this.s = s;
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        if(this.w > o.w) return 1;
        else return -1;
    }
}