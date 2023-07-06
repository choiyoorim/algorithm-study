import java.io.*;
import java.util.StringTokenizer;

public class BJ11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int arrayLength = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        long[] sArray = new long[arrayLength + 1];
        st = new StringTokenizer(bf.readLine());
        for(int i = 1; i <= arrayLength; i++){
            sArray[i] = sArray[i-1] + Integer.parseInt(st.nextToken());
        }
        for(int k = 0; k<count; k++){
            st = new StringTokenizer(bf.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(sArray[j] - sArray[i-1]);
        }
    }
}
