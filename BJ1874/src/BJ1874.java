import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BJ1874 {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int numbers[] = new int[N];
        for(int i = 0; i<N; i++){
            numbers[i] = sc.nextInt();
        }
        int num = 1;
        boolean result = true;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i<numbers.length; i++){
            int check = numbers[i];
            if(check >= num){
                while(check >= num){
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }
            else{
                int n = stack.pop();
                if(n > check){
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else{
                    sb.append("-\n");
                }
            }
        }
        if(result) System.out.println(sb.toString());
    }
}
