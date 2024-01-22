import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br. readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long A[] = new long[N];
        for(int i = 0; i<N; i++){
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);
        st = new StringTokenizer(br.readLine());
        long M = Long.parseLong(st.nextToken());

        long left = 1, right = A[A.length - 1];
        long ans = 0;

        while(left<=right){
            long total = 0;
            long mid = (left + right) / 2;
            for(int i = 0; i<N; i++){
                if(A[i] < mid) {
                    total += A[i];
                }
                else{
                    total += mid;
                }
            }
            if(total > M) right = mid - 1;
            else {
                ans = mid; // 정답 후보에 넣어둠
                left = mid + 1; // 최댓값을 찾아가야하니 일단 조건은 만족하더라도 이분탐색을 계속함
            }
        }

        System.out.println(ans);
    }
}
