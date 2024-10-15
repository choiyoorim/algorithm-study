import java.util.*;

public class PRO258712T {
    public static int solution(String[] friends, String[] gifts){
        Map<String, Integer> friendName = new HashMap<>();
        int N = friends.length;
        for(int i = 0; i<N; i++){
            friendName.put(friends[i], i);
        }

        int[] index = new int[N];
        int[][] info = new int[N][N];

        for(String s : gifts){
            String[] str = s.split(" ");
            index[friendName.get(str[0])]++;
            index[friendName.get(str[1])]--;
            info[friendName.get(str[0])][friendName.get(str[1])]++;
        }

        int ans = 0;
        for(int i = 0; i<N; i++){
            int cnt = 0;
            for(int j = 0; j<N; j++){
                if(i == j) continue;
                if(info[i][j] > info[j][i]) cnt++;
                else if(info[i][j] == info[j][i] && index[i] > index[j]) cnt++;
            }
            ans = Math.max(cnt, ans);
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"muzi", "ryan", "frodo", "neo"}, new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}));
    }
}
