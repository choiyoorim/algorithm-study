import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dNode root = new dNode();
        while(N>0){
            st = new StringTokenizer(br.readLine());
            char[] str = st.nextToken().toCharArray();
            dNode now = root;
            for(int i =0; i<str.length; i++){
                char c = str[i];
                if(now.next[c-'a'] == null){
                    now.next[c-'a'] = new dNode();
                }
                now = now.next[c-'a'];
                if(i==str.length-1){
                    now.isEnd = true;
                }
            }
            N--;
        }
        int count = 0;
        while(M>0){
            st = new StringTokenizer(br.readLine());
            char[] str = st.nextToken().toCharArray();
            dNode now = root;
            for(int i = 0; i<str.length; i++){
                char c = str[i];
                if(now.next[c-'a'] == null) break;
                now = now.next[c-'a'];
                if(i == str.length-1 && now.isEnd) count++;
            }
            M--;
        }

        System.out.println(count);
    }
}

class dNode{
    dNode[] next = new dNode[26];
    boolean isEnd;
}
