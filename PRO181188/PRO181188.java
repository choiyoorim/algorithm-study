import java.util.Arrays;

public class PRO181188 {
    public static int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> {return o1[1] - o2[1];});

        int end = 0;
        int cnt = 0;
        for(int[] s : targets){
            if(s[0] >= end) { // end 정수 부분은 앞의 범위에 포함되면 안되기 때문에
                end = s[1];
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}}));
    }
}
