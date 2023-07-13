import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BJ13417 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            ArrayDeque<Character> cards = new ArrayDeque<>();
            cards.addFirst(st.nextToken().charAt(0));
            for(int k = 1; k < M; k++){
                char c = st.nextToken().charAt(0);
                if(cards.peekFirst() >= c){
                    cards.addFirst(c);
                }
                else{
                    cards.addLast(c);
                }
            }
            for(char c : cards){
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
