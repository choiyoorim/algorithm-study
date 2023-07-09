import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int[] array = new int[N+1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 1; i<=N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        int start = 1;
        int end = N;
        int count = 0;

        while(start < end){
            int sum = array[start] + array[end];
            if(sum > M){
                end--;
            }
            else if(sum < M){
                start++;
            }
            else{
                count++;
                start++;
                end--;
            }
        }
        System.out.println(count);
    }
}
