import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int A[] = new int[N];
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        int zeroCount = 0;
        int oneCount = 0;

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if(num > 1){
                plus.add(num);
            }
            else if(num < 0){
                minus.add(num);
            }
            else if(num == 0){
                zeroCount++;
            }
            else{
                oneCount++;
            }
        }

        int sum = 0;
        while(plus.size()>1){
            int data1, data2;
            data1 = plus.remove();
            data2 = plus.remove();
            sum += data1 * data2;
        }
        if(!plus.isEmpty()) sum += plus.remove();

        while(minus.size()>1){
            int data1, data2;
            data1 = minus.remove();
            data2 = minus.remove();
            sum += data1 * data2;
        }
        if(!minus.isEmpty()) {
            if(zeroCount <= 0){
                sum += minus.remove();
            }
        }

        sum += oneCount;

        System.out.println(sum);
    }
}
