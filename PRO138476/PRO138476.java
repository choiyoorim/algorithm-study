import java.util.*;

public class PRO138476 {
    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> countOfSize = new HashMap<>();
        for(Integer i : tangerine){
            countOfSize.put(i, countOfSize.getOrDefault(i, 0) + 1);
        }

        List<Integer> valueList = new ArrayList(countOfSize.values());
        Collections.sort(valueList, Collections.reverseOrder());

        int sum = 0;
        for(Integer s: valueList){
            sum += s;
            answer++;
            if(sum >= k) {
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int answer = solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3});
        System.out.println(answer);
    }
}
