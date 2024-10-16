import java.util.Arrays;
import java.util.Stack;

public class PRO154539 {
    public static int[] solution(int[] numbers) {
        int[] answer = {};
        answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i<numbers.length; i++){
            while(!stack.empty() && numbers[stack.peek()] < numbers[i]){
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] answer = solution(new int[]{2, 3, 3, 5});
        for(int i = 0; i<answer.length; i++){
            System.out.print(answer[i] + " ");
        }
    }
}
