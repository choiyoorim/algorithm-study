import java.util.HashMap;
import java.util.*;
public class PRO131701 {
    public static int solution(int[] elements) {
        int answer = 0;
        int N = elements.length;
        HashSet<Integer> set = new HashSet<>();
        int size = 1;
        while(size <= N){
            int sum = 0;
            for(int i = 0; i<size; i++){
                sum += elements[i % N];
                set.add(sum);
            }
            for(int i = 0; i<N; i++){
                sum -= elements[i % N];
                sum += elements[(i + size) % N];
                set.add(sum);
            }
            size++;
        }

        answer = set.size();

        return answer;
    }
    public static void main(String[] args) {
        int ans = solution(new int[]{7,9,1,1,4});
        System.out.println(ans);
    }
}
