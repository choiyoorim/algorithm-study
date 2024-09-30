import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BJ9252 {
    static char[] first;
    static char[] second;
    static long[][] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        first = br.readLine().toCharArray();
        second = br.readLine().toCharArray();
        D = new long[first.length + 1][second.length + 1];
        ArrayList<Character> ans = new ArrayList<>();

        for(int i = 1; i<=first.length; i++){
            for(int j = 1; j<=second.length; j++){
                if(first[i-1] == second[j-1]) {
                    D[i][j] = D[i-1][j-1] + 1;
                }
                else{
                    D[i][j] = Math.max(D[i-1][j], D[i][j-1]);
                }
            }
        }

        System.out.println(D[first.length][second.length]);


        int x = first.length;
        int y = second.length;
        while(x != 0 && y != 0){
            if(first[x-1] == second[y-1]){
                ans.add(first[x-1]);
                x -= 1;
                y -= 1;
            }
            else{
                if(D[x-1][y] > D[x][y-1]) x -= 1;
                else y -= 1;
            }
        }


        if(D[first.length][second.length] != 0){
            for(int i = ans.size()-1; i>=0; i--){
                System.out.print(ans.get(i));
            }
        }
    }
}
