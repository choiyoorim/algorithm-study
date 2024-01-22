import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int B[] = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<M; i++){
            int target = B[i];
            boolean exist = false;
            int left = 0;
            int right = A.length - 1;
            int mid;
            while(left <= right){
                mid = (left + right) / 2;
                if(A[mid] > target){
                    right = mid - 1;
                }
                else if (A[mid] < target){
                    left = mid + 1;
                }
                else{
                    exist = true;
                    break;
                }
            }

            if(exist) sb.append("1 ");
            else sb.append("0 ");
        }

        System.out.println(sb);

    }
}
