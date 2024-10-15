import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PRO178870 {
    public static int[] solution(int[] sequence, int k) {
        int[] answer = {};
        int N = sequence.length;
        int[][] sum = new int[N][N];
        ArrayList<int[]> preAnswer = new ArrayList<>();

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                sum[i][j] += sequence[j];
            }
        }

        for(int i = 0; i<N-1; i++){
            for(int j = i; j<N-1; j++){
                sum[i][j+1] += sum[i][j];
                if(sum[i][j+1] == k) {
                    preAnswer.add(new int[]{i, j+1});
                }
            }
        }

        for(int j = 0; j<N; j++){
            if(sum[N-1][j] == k) {
                preAnswer.add(new int[]{N-1, j});
            }
        }

        if(preAnswer.size() == 1) return preAnswer.get(0);
        else{
            Collections.sort(preAnswer, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if((o1[1] - o1[0]) == (o2[1] - o2[0])){
                        return (o1[0]-o2[0]);
                    }
                    return (o1[1] - o1[0]) - (o2[1] - o2[0]);
                }
            });

            return preAnswer.get(0);
        }
    }

    public static void main(String[] args) {
        int[] ans = solution(new int[]{2, 2, 2, 2, 2}, 6);
        System.out.println(ans[0]+ " " + ans[1]);
//        System.out.println(solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5));
    }
}
