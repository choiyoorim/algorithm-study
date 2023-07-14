import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ17298 {
    public static void main(String[] args) throws IOException {
        Deque<Integer> stack = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] number = new int[N];
        int[] answer = new int[N];
        for(int i = 0; i < N; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }
        stack.addLast(0);
        for(int i = 1; i < N; i++){
            while(!stack.isEmpty() && number[stack.peekLast()] < number[i]){
                answer[stack.pollLast()] = number[i];
            }
            stack.addLast(i);
        }
        while (!stack.isEmpty()){
            answer[stack.pollLast()] = -1;
        }

        for(int i = 0; i < N; i++){
            sb.append(answer[i] + " ");
        }
        System.out.println(sb);
    }
}
