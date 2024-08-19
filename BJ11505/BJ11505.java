import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11505 {
    static long[] tree;
    final static int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int length = N;
        int height = 0;

        while(length > 0){
            length /= 2;
            height++;
        }

        int treeSize = (int)Math.pow(2, height + 1);
        int startIndex = treeSize / 2 - 1;
        tree = new long[treeSize];

        for(int i = 0; i<tree.length; i++){
            tree[i] = 1;
        }

        for(int i = startIndex + 1; i<=startIndex + N; i++){
            tree[i] = Long.parseLong(br.readLine());
        }

        setTree(treeSize - 1);

        for(int i = 0; i< M + K; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            Long C = Long.parseLong(st.nextToken());

            if(A == 1){
                changeVar(B+startIndex, C);
            }
            else if(A == 2){
                long Multiple = getMultiple(B+startIndex, (int)(C + startIndex));
                System.out.println(Multiple);
            }
            else return;
        }

    }

    private static void setTree(int index){
        while(index != 1){
            tree[index/2] = tree[index] * tree[index/2] % MOD ;
            index--;
        }
    }

    private static void changeVar(int index, long num){
        tree[index] = num;
        while(index > 1){
            index /= 2;
            tree[index] = tree[index * 2] % MOD * tree[index * 2 + 1] % MOD;
        }
    }

    private static long getMultiple(int start, int end){
        long multiple = 1;
        while(start<=end){
            if(start%2 == 1) {
                multiple = multiple * tree[start] % MOD;
                start++;
            }
            if(end%2 == 0){
                multiple = multiple * tree[end] % MOD;
                end--;
            }
            start /= 2;
            end /= 2;
        }
        return multiple;
    }
}
