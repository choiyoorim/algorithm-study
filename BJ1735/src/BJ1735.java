import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int s2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());

        int m3 = m1 * m2 / gcd(m1, m2);
        int s3 = (s1 * (m3 / m1)) + (s2 * (m3 / m2));

        int finalCheck = gcd(m3,s3);
        if(finalCheck != 0){
            m3 = m3 / finalCheck;
            s3 = s3 / finalCheck;
        }

        System.out.println(s3 + " " + m3);
    }

    private static int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}
