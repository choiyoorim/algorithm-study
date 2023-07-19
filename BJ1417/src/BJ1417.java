import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<N-1; i++){
            queue.add(Integer.parseInt(br.readLine()));
        }

        int person = 0;
        while(!queue.isEmpty()){
            if(dasom <= queue.peek()){
                person++;
                dasom++;
                int num = queue.poll() - 1;
                queue.add(num);
            }
            else{
                queue.poll();
            }
        }
        System.out.println(person);
    }
}
