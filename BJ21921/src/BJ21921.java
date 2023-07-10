import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ21921 {
    static int visitorSum;
    static int visitorMax;
    static int maxCount;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] visitor = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i<N; i++){
            visitor[i] = Integer.parseInt(st.nextToken());
        }

        visitorSum = 0;
        for(int i = 0; i<X; i++){
            visitorSum+=visitor[i];
            maxCount = 1;
        }
        visitorMax = visitorSum;

        for(int i = X; i < N; i++){
            int j = i - X;
            visitorSum += visitor[i];
            visitorSum -= visitor[j];
            if(visitorSum > visitorMax) {
                visitorMax = visitorSum;
                maxCount = 1;
            }
            else if(visitorSum == visitorMax){
                maxCount++;
            }
        }

        if(visitorMax == 0){
            System.out.println("SAD");
        }
        else {
            System.out.println(visitorMax);
            System.out.println(maxCount);
        }
    }
}
