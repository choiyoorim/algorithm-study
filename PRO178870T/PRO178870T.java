public class PRO178870T {
    public static int[] solution(int[] sequence, int k){
        int[] answer = {0, sequence.length};
        int start = 0, end = 0;
        int sum = 0;
        sum += sequence[start];
        while(start < sequence.length && end < sequence.length){
            if(sum < k){
                end++;
                if(end >= sequence.length) break;
                sum += sequence[end];
            }
            else if(sum > k){
                sum -= sequence[start];
                start++;
            }
            else {
                if((answer[1] - answer[0]) > (end - start) || ((answer[1] - answer[0]) == (end - start) && answer[0] > start)){
                    answer[0] = start;
                    answer[1] = end;
                }
                sum -= sequence[start];
                start++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] answer = solution(new int[]{2, 2, 2, 2, 2}, 6);
        System.out.println(answer[0] + " " + answer[1]);
    }
}
