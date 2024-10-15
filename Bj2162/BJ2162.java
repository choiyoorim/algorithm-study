import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2162 {
    static int parent[] = new int[3001];
    static int L[][] = new int[3001][4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 1; i<=N; i++){
            parent[i] = -1;
        }

        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            L[i][0] = Integer.parseInt(st.nextToken());
            L[i][1] = Integer.parseInt(st.nextToken());
            L[i][2] = Integer.parseInt(st.nextToken());
            L[i][3] = Integer.parseInt(st.nextToken());

            for(int j = 1; j<i; j++){
                if(isCross(L[i][0], L[i][1], L[i][2], L[i][3], L[j][0], L[j][1], L[j][2], L[j][3])){
                    union(i, j);
                }
            }
        }

        int ans = 0; int count = 0;
        for(int i = 1; i<=N; i++){
            if(parent[i] < 0){
                ans++;
                count = Math.min(count, parent[i]); // 제일 작은 값(절댓값이 제일 큰 값을 출력해야하니까 == 그룹의 최대 선분 개수)
            }
        }

        System.out.println(ans);
        System.out.println(-count);
    }

    public static int find(int i){
        if(parent[i]<0) return i;
        else return parent[i] = find(parent[i]);
    }
    public static void union(int i , int j){
        int p = find(i); // 3
        int q = find(j); // 1
        if(p == q) return;
        parent[p] += parent[q]; //개수 추가
        parent[q] = p; //연결된 부모로 변경
    }

    public static int ccw(int x1, int y1, int x2, int y2, int x3, int y3){
        int tmp = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);
        if(tmp > 0) return 1;
        else if(tmp < 0) return -1;
        else return 0;
    }
    public static boolean isCross(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
        int abc = ccw(x1, y1, x2, y2, x3, y3);
        int abd = ccw(x1, y1, x2, y2, x4, y4);
        int cda = ccw(x3, y3, x4, y4, x1, y1);
        int cdb = ccw(x3, y3, x4, y4, x2, y2);

        if(abc * abd == 0 && cda * cdb == 0){
            return isOverlab(x1, y1, x2, y2, x3, y3, x4, y4);
        }
        else if(abc * abd <= 0 && cda * cdb <=0){
            return true;
        }
        return false;
    }

    public static boolean isOverlab(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
        if(Math.min(x1, x2)<=Math.max(x3, x4) && Math.min(x3, x4)<= Math.max(x1, x2)
        && Math.min(y1, y2)<=Math.max(y3, y4) && Math.min(y3, y4) <= Math.max(y1, y2)){
            return true;
        }
        else return false;
    }
}
