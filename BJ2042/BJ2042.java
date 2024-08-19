import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2042 {
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, C, S;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        int k = 0;
        int length = N;
        while(length > 0){
            length /= 2;
            k++;
        }

        int treeSize = (int) Math.pow(2, k+1); //16
        tree = new long[treeSize + 1]; //0~17
        int nodeStartIndex = treeSize / 2 - 1;
        for(int i = nodeStartIndex + 1; i<=nodeStartIndex + N; i++){
            tree[i] = Long.parseLong(br.readLine());
        }

        setTree(treeSize - 1);
        for(int i = 0; i < C + S; i++){
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1){
                changeVal(nodeStartIndex+b, c);
            } else if(a==2){
                b = b + nodeStartIndex;
                c = c + nodeStartIndex;
                System.out.println(getSum(b, (int) c));
            } else return;
        }
    }

    private static void setTree(int i){
        while(i != 1){
            tree[i/2] += tree[i];
            i--;
        }
    }

    private static void changeVal(int index, long num){
        long diff = num - tree[index];
        while(index > 0){
            tree[index] = tree[index] + diff;
            index = index/2;
        }
    }

    private static long getSum(int start, int end){
        long partSum = 0;
        while(start <= end){
            if(start % 2 == 1) {
                partSum += tree[start];
                start++;
            }
            if(end % 2 == 0){
                partSum += tree[end];
                end--;
            }
            start = start/2;
            end = end/2;
        }

        return partSum;
    }
}
