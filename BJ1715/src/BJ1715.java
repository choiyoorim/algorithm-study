import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            queue.add(Integer.parseInt(st.nextToken()));
        }
        int data1, data2;
        int sum = 0;

        while(queue.size() != 1){
            data1 = queue.remove();
            data2 = queue.remove();
            sum += data1 + data2;
            queue.add(data1 + data2);
        }

        System.out.println(sum);
    }
}
