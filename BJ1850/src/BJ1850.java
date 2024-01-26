import java.io.*;
import java.util.StringTokenizer;

public class BJ1850 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long gcd = gcd(A, B);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(gcd > 0){
            bw.write("1");
            gcd--;
        }

        bw.flush();
        bw.close();
    }

    private static long gcd(long a, long b){
        if(b==0) return a;
        else return gcd(b, a % b);
    }
}
