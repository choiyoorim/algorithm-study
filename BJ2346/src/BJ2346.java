import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BJ2346 {
    static class Balloon{
        public int bNum;
        public int pNum;

        public Balloon(int bNum, int pNum){
            this.bNum = bNum;
            this.pNum = pNum;
        }
    }
    public static void main(String[] args) throws IOException {

        ArrayDeque<Balloon> ballons = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int pNum = Integer.parseInt(st.nextToken());
            ballons.addLast(new Balloon(i, pNum));
        }

        Balloon balloon = (ballons.pollFirst());
        sb.append(balloon.bNum+" ");
        while(!ballons.isEmpty()){
            if(balloon.pNum > 0){
                for(int i = 1; i < balloon.pNum; i++){
                    ballons.addLast(ballons.pollFirst());
                }
                balloon = ballons.pollFirst();
                sb.append(balloon.bNum+" ");
            }
            else{
                for(int i = 1; i < -balloon.pNum; i++){
                    ballons.addFirst(ballons.pollLast());
                }
                balloon = ballons.pollLast();
                sb.append(balloon.bNum+" ");
            }
        }
        System.out.println(sb.toString());
    }


}
