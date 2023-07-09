import java.util.Scanner;

public class BJ2003 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int M = scn.nextInt();
        int count = 0;
        int start = 1; int end = 1;
        int[] num = new int[N+2];
        for(int i = 1; i <= N; i++){
            num[i] = scn.nextInt();
        }
        int sum = num[start];

        while(end != N+1){
            if(sum == M){
                count++;
                end++;
                sum += num[end];
            }
            else if(sum > M){
                sum -= num[start];
                start++;
            }
            else{
                end++;
                sum+=num[end];
            }
        }
        System.out.println(count);
    }
}
