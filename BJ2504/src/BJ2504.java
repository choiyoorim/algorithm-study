import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BJ2504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.next();

        int result = 0;
        int mul = 1;
        boolean flag = true;
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i<in.length(); i++){
            switch (in.charAt(i)) {
                case '(':
                    stack.addLast('(');
                    mul *= 2;
                    break;
                case '[':
                    stack.addLast('[');
                    mul *= 3;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peekLast() != '(') {
                        result = 0;
                        flag = false; // 오류 발생 후 뒤에부터 정상 식이 오면 값이 더해지더라도 오류문이므로 0이 나와야함.
                        break;
                    }

                    if (in.charAt(i - 1) == '(') result += mul;
                    stack.pollLast();
                    mul /= 2;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peekLast() != '[') {
                        result = 0;
                        flag = false;
                        break;
                    }

                    if (in.charAt(i - 1) == '[') result += mul;
                    stack.pollLast();
                    mul /= 3;
                    break;
            }
        }
        System.out.println(!stack.isEmpty() || !flag ? 0 : result);
    }
}
