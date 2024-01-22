import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] timeline = new int[N][2];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            timeline[i][0] = Integer.parseInt(st.nextToken());
            timeline[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(timeline, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int end = -1;
        for(int i = 0; i<N; i++){
            if(timeline[i][0] >= end){
                end = timeline[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
