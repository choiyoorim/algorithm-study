import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ10816 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int N = Integer.parseInt(st.nextToken());
//        st = new StringTokenizer(br.readLine());
//        int A[] = new int[N];
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for(int i = 0; i<N; i++){
//            A[i] = Integer.parseInt(st.nextToken());
//            Integer count = map.get(A[i]);
//            if(count == null){
//                map.put(A[i],1);
//            }
//            else{
//                map.put(A[i],++count);
//            }
//        }
//
//        st = new StringTokenizer(br.readLine());
//        int M = Integer.parseInt(st.nextToken());
//
//        st = new StringTokenizer(br.readLine());
//        int B[] = new int[M];
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i<M; i++){
//            B[i] = Integer.parseInt(st.nextToken());
//            Integer num = map.get(B[i]);
//            if(num == null) sb.append(0 + " ");
//            else sb.append(num + " ");
//        }
//
//        System.out.println(sb);
//    }
    static int A[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        A = new int[N];
        for(int i = 0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<M; i++){
            int target = Integer.parseInt(st.nextToken());
            sb.append(upperBound(target) - lowerBound(target) + " ");
        }

        System.out.println(sb);
    }

    public static int lowerBound(int target){
        int left = 0;
        int right = A.length;
        while(left <right){
            int mid = (left + right) / 2;
            int midn = A[mid];
            if(target <= midn){
                right = mid; //같은 값(타겟 값) 중에도 가장 왼쪽에 있는 걸 찾기 위해서
            }
            else{
                left = mid + 1; //같은 값(타겟 값) 중에도 가장 왼쪽에 있는 걸 찾기 위해서
            }
        }
        return left;
    }

    public static int upperBound(int target){
        int left = 0;
        int right = A.length;
        while(left < right){
            int mid = (left + right) / 2;
            int midn = A[mid];
            if(target < midn){
                right = mid; //같은 값(타겟 값) 중에도 가장 왼쪽에 있는 걸 찾기 위해서
            }
            else{
                left = mid + 1; //같은 값(타겟 값) 중에도 가장 왼쪽에 있는 걸 찾기 위해서
            }
        }
        return left;
    }
}
