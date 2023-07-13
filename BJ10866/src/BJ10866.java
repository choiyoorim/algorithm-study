import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int number;
            switch (order) {
                case "push_back":
                    number = Integer.parseInt(st.nextToken());
                    deque.addLast(number);
                    break;
                case "push_front":
                    number = Integer.parseInt(st.nextToken());
                    deque.addFirst(number);
                    break;
                case "pop_front":
                    if(deque.isEmpty()){
                        System.out.println("-1");
                    }
                    else{
                        System.out.println(deque.pollFirst());
                    }
                    break;
                case "pop_back":
                    if(deque.isEmpty()){
                        System.out.println("-1");
                    }
                    else{
                        System.out.println(deque.pollLast());
                    }
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    if(deque.isEmpty()){
                        System.out.println("1");
                    }
                    else{
                        System.out.println("0");
                    }
                    break;
                case "front":
                    if(deque.isEmpty()){
                        System.out.println("-1");
                    }
                    else{
                        System.out.println(deque.peekFirst());
                    }
                    break;
                case "back":
                    if(deque.isEmpty()){
                        System.out.println("-1");
                    }
                    else{
                        System.out.println(deque.peekLast());
                    }
                    break;
            }
        }
    }
}
