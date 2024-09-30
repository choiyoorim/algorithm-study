import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14003 {
    static int index, maxLength;
    static int[] A, B, D, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[1000001];
        B = new int[1000001];
        D = new int[1000001];
        ans = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        B[++maxLength] = A[1];
        D[1] = 1;
        for(int i=2; i<=N; i++){
            if(A[i] > B[maxLength]){
                B[++maxLength] = A[i];
                D[i] = maxLength;
            }
            else{
                index = binarysearch(1, maxLength, A[i]);
                B[index] = A[i];
                D[i] = index;
            }
        }
        System.out.println(maxLength);
        index = maxLength;
        int x = B[maxLength] + 1;
        for(int i = N; i>=1; i--){
            if(D[i] == index && A[i] < x){
                ans[index] = A[i];
                x = A[i];
                index--;
            }
        }

        for(int i = 1; i<= maxLength; i++){
            System.out.print(ans[i] + " ");
        }
    }

    static int binarysearch(int l, int r, int now){
        int mid;
        while (l < r){
            mid = (l + r)/2;
            if(B[mid] < now){
                l = mid + 1;
            }
            else{
                r = mid;
            }
        }
        return l;
    }
}
