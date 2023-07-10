import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        long[] array = new long[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i = 0; i<N; i++){
            array[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(array);

        int count = 0;
        for(int i = 0; i<N; i++){
            int start = 0; int end = N-1;
            while(start<end){
                long sum = array[start] + array[end];
                if(sum == array[i]){
                    if(i != start && i != end){
                        count++;
                        break;
                    }
                    else if(i == start){
                        start++;
                    }
                    else if(i == end) {
                        end--;
                    }
                }
                else if(sum > array[i]){
                    end--;
                }
                else{
                    start++;
                }
            }
        }
        System.out.println(count);
    }
}
