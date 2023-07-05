import java.io.*;
import java.util.StringTokenizer;

public class BJ1546 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];
        double[] newScore = new double[n];
        double max = 0;
        double sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            score[i] = Integer.parseInt(st.nextToken());
            if(score[i] > max) max = score[i];
        }
        for(int i = 0; i<n; i++){
            newScore[i] = score[i] / (double) max * 100.0;
            sum += newScore[i];
        }
        bw.write(String.valueOf(sum / (double)n));
        bw.flush();
    }
}
