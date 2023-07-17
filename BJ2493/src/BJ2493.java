import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] array = new int[N+1];
        int[] answer = new int[N+1];
        for(int i = 1; i <= N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(1);
        for(int i = 2; i <= N; i++){
            while(!stack.isEmpty()){
                if(array[stack.peekLast()] < array[i]){
                    stack.pollLast();
                }
                else{
                    answer[i] = stack.peekLast();
                    stack.addLast(i);
                    break;
                }
            }
            stack.addLast(i);
        }
        for(int i = 1; i<=N; i++){
            sb.append(answer[i] + " ");
        }
        System.out.println(sb);
    }
}
