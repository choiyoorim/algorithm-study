import java.util.Scanner;

public class BJ11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] S = new int[N];
        for(int i = 0; i<N; i++){
            A[i] = sc.nextInt();
        }
        for(int i = 1; i<N; i++){
            int insert = i;
            int insert_value = A[i];
            for(int j = i-1; j>=0; j--){
                if(A[j] < A[i]){
                    insert = j + 1;
                    break;
                }
                if(j == 0){
                    insert = 0;
                }
            }
            for(int j = i; j>insert; j--){
                A[j] = A[j-1];
            }
            A[insert] = insert_value;
        }
        S[0] = A[0];
        for(int i = 1; i<N; i++){
            S[i] = S[i-1] + A[i];
        }
        int sum = 0;
        for(int i = 0; i<N; i++){
            sum += S[i];
        }
        System.out.println(sum);
    }
}
