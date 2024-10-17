import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class PRO118667 {
    public static int solution(int[] queue1, int[] queue2) {;
        int n = queue1.length;
        int[] mergedQueue = new int[2 * n];

        int answer = Integer.MAX_VALUE;
        long queue1sum = 0, queue2sum = 0;
        for(int i = 0; i<n; i++){
            mergedQueue[i] = queue1[i];
            queue1sum += queue1[i];
        }
        for(int i = n; i< 2*n; i++){
            mergedQueue[i] = queue2[i % n];
            queue2sum += queue2[i%n];
        }

        if((queue1sum + queue2sum) % 2 != 0) {
            answer = -1;
            return answer;
        }

        long targetSum = (queue1sum + queue2sum) / 2;

        int count = 0;
        int l1 = 0, r1 = n-1, l2 = n, r2 = 2*n-1;
        while(count < 4 * n){
            if(queue1sum > targetSum){
                l1 = (l1 + 1) % (2 * n);
                r2 = (r2 + 1) % (2 * n);
                queue1sum -= mergedQueue[r2];
                queue2sum += mergedQueue[r2];

                count++;
            }
            else if(queue1sum < targetSum){
                r1 = (r1 + 1) % (2 * n);
                l2 = (l2 + 1) % (2 * n);
                queue1sum += mergedQueue[r1];
                queue2sum -= mergedQueue[r1];

                count++;
            }

            if(queue1sum == targetSum){
                break;
            }
        }

        answer = (queue1sum == targetSum) ? count : -1;

        return answer;
    }

    public static void main(String[] args) {
        int answer = solution(new int[]{1, 4}, new int[]{4, 8});
        System.out.println(answer);
    }
}
