import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[2000001];
        for(int i = 2; i < A.length; i++){
            A[i] = i;
        }

        for(int i = 2; i < Math.sqrt(A.length); i++){
            if(A[i] == 0) continue;
            for(int j = i + i; j < A.length; j = j + i){
                A[j] = 0;
            }
        }

        int i = N;
        while(true){
            if(A[i] != 0){
                if(isPalindrome(A[i])) {
                    System.out.println(A[i]);
                    break;
                }
            }
            i++;
        }
    }

    private static boolean isPalindrome(int N){
        char temp[] = String.valueOf(N).toCharArray();
        int start = 0;
        int end = temp.length - 1;
        while(start<end){
            if(temp[start] != temp[end]) return false;
            start++;
            end--;
        }
        return true;
    }
}
