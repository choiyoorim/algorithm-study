import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10868 {
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int height = 0;
        int length = N;
        while(length > 0){
            length /= 2;
            height++;
        }
        int treeSize = (int) Math.pow(2, height + 1);
        int startIndex = treeSize / 2 - 1;
        tree = new long[treeSize+1];
        for(int i = 0; i<tree.length; i++){
            tree[i] = Long.MAX_VALUE;
        }

        for(int i = startIndex + 1; i <= startIndex + N; i++){
            tree[i] = Long.parseLong(br.readLine());
        }

        setTree(treeSize - 1);

        for(int k = 0; k<M; k++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Long min = getMin(A+startIndex, B+startIndex);
            System.out.println(min);
        }
    }

    private static void setTree(int index){
        while(index != 1){
            if(tree[index/2] > tree[index]) tree[index/2] = tree[index];
            index--;
        }
    }

    private static long getMin(int s, int e){
        long Min = Long.MAX_VALUE;
        while(s<=e){
            if(s % 2 == 1) {
                Min = Math.min(tree[s], Min);
                s++;
            }
            if(e % 2 == 0){
                Min = Math.min(tree[e], Min);
                e--;
            }
            s = s / 2;
            e = e / 2;
        }
        return Min;
    }
}
