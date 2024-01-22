import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, C;
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        long home[] = new long[N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            home[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(home);

        long left=1, right=home[N-1] - home[0];
        long ans = 0;
        while(left <= right){
            long mid = (left + right) / 2;

            int count = 1;
            long lastX = home[0];
            for(int i = 1; i<N; i++){
                if(home[i] - lastX >= mid){
                    count++;
                    lastX = home[i];
                }
            }
            if(count >= C){
                ans = mid;
                left = mid + 1;
            }
            else{

                right = mid - 1;
            }
        }

        System.out.println(ans);

    }
}
