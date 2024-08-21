import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ6603 {
    static  int[] list;
    static Stack<Integer> stack;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        while (true){
            list = new int[a];
            for(int i = 0; i<a; i++){
                list[i] = Integer.parseInt(st.nextToken());
            }

            stack = new Stack<>();
            visited = new boolean[a];
            select(0, 6);
            System.out.println();

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            if(a == 0) return;
        }
    }

    private static void select(int a, int b){
        if(stack.size() == b){
            for(int i : stack){
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }


        for(int i = a; i<list.length; i++){
            if(!visited[i]){
                visited[i] = true;
                stack.push(list[i]);
                select(i, b);
                stack.pop();
                visited[i] = false;
            }
        }
    }
}
