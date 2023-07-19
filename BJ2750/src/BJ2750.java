import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        for(int i = 0; i<N; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i<N-1; i++){
            for(int j = 0; j<N-1-i; j++){
                if(a[j] > a[j+1]){
                    int tmp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = tmp;
                }
            }
        }

        for(int i = 0; i<N; i++){
            System.out.println(a[i]);
        }
    }
}
