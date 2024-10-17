import java.util.HashMap;

public class PRO131127 {
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> wantNumber = new HashMap<>();
        HashMap<String, Integer> discountCount = new HashMap<>();
        int i = 0;
        for(String s : want){
            wantNumber.put(s, number[i]);
            i++;
        }

        for(int j = 0; j<10; j++){
            discountCount.put(discount[j], discountCount.getOrDefault(discount[j],0) + 1);
        }

        int days = discount.length;
        int start = 0, end = start + 10;
        if(isCheck(wantNumber, discountCount)){
            answer++;
        };

        while(start < (days - 10 + 1) && end < days){
            discountCount.put(discount[start], discountCount.get(discount[start])- 1);
            discountCount.put(discount[end], discountCount.getOrDefault(discount[end],0) + 1);
            if(isCheck(wantNumber, discountCount)){
                answer++;
            };
            start++; end++;
        }

        return answer;
    }

    private static boolean isCheck(HashMap<String, Integer> check, HashMap<String,Integer> count){
        for(String s : check.keySet()){
            if(check.get(s) == count.get(s)) continue;
            else return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int answer = solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"});
        System.out.println(answer);
    }
}
