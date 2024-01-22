import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2023 {
    static int N;
    static void dfs(int number,int jarisu){
        if(jarisu == N){
            if(isPrime(number)){
                System.out.println(number);
            }
            return;
        }


        for(int i=1; i<10; i++){
            if(i % 2 == 0) continue;
            if(isPrime(number * 10 + i)){
                dfs(number * 10 + i, jarisu + 1);
            }
        }
    }
    static boolean isPrime(int N){
        for(int i = 2; i<N/2; i++){
            if(N%i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);
    }
}
