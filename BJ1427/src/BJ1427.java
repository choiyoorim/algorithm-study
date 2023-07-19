import java.util.Scanner;

public class BJ1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] A = new int[str.length()];
        for(int i = 0; i<str.length(); i++){
            A[i] = Integer.parseInt(str.substring(i,i+1));
        }
        for(int i = 0; i<str.length(); i++){
            int max = i;
            for(int j = i + 1; j<str.length(); j++){
                if(A[j] > A[max]) max = j;
            }
            if(A[i] < A[max]){
                int tmp = A[max];
                A[max] = A[i];
                A[i] = tmp;
            }
        }
        for(int i = 0; i<str.length(); i++){
            System.out.print(A[i]);
        }
    }
}
