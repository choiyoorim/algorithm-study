import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10972 {
    static int N;
    static int[] question;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        question = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            question[i] = Integer.parseInt(st.nextToken());
        }

        nextPermutation();
    }

    private static void nextPermutation(){
        int idx = N - 1;
        while(idx > 0 && question[idx] < question[idx-1]){
            idx--;
        }

        if(idx == 0) {
            System.out.println(-1);
            return;
        }

        int flag = N - 1;
        while(flag > idx && question[idx - 1] > question[flag]){
            flag--;
        }

        int temp = question[idx-1];
        question[idx-1] = question[flag];
        question[flag] = temp;

        Arrays.sort(question, idx, N);

        for(int i = 0; i<N; i++){
            System.out.print(question[i] + " ");
        }

    }
}
