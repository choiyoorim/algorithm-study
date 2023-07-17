import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ10845 {
    public static void main(String[] args) throws IOException {
        Deque<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            switch (order){
                case "push":
                    queue.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(queue.isEmpty()){
                        sb.append(-1 + "\n");
                    }
                    else{
                        sb.append(queue.pollFirst() + "\n");
                    }
                    break;
                case "size":
                    sb.append(queue.size() + "\n");
                    break;
                case "empty":
                    if(queue.isEmpty()) sb.append(1 + "\n");
                    else sb.append(0 + "\n");
                    break;
                case "front":
                    if(queue.isEmpty()){
                        sb.append(-1 + "\n");
                    }
                    else{
                        sb.append(queue.peekFirst() + "\n");
                    }
                    break;
                case "back":
                    if(queue.isEmpty()){
                        sb.append(-1 + "\n");
                    }
                    else{
                        sb.append(queue.peekLast() + "\n");
                    }
                    break;
            }

        }
        System.out.println(sb);
    }
}
