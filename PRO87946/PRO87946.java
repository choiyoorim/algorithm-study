import java.lang.reflect.Array;
import java.util.*;

public class PRO87946 {
    static boolean[] visited;
    static int maxCount = 0;

    public static int solution(int k, int[][] dungeons) {
        int answer = -1;

        visited = new boolean[dungeons.length];
        DFS(k, 0, dungeons);

        answer = maxCount;
        return answer;
    }

    public static void DFS(int now, int count, int[][] dungeons) {
        if (count > maxCount) maxCount = count;
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && now >= dungeons[i][0]) {
                visited[i] = true;
                DFS(now - dungeons[i][1], count + 1, dungeons);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int a = solution(80, new int[][]{{80,20},{50,40},{30,10}});
        System.out.println(a);
    }
}

