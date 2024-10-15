class PRO258712 {
    static int[][] giftsInfo;
    static int[][] giftsCount;
    static int[] rateOfGift, willGivenGift;
    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int N = friends.length;
        giftsInfo = new int[N][N];
        giftsCount = new int[N][2];
        rateOfGift = new int[N];
        willGivenGift = new int[N];

        for(int i = 0; i<gifts.length; i++){
            String[] friendList = gifts[i].split(" ");
            int indexWhoGive = 0, indexWhoGiven = 0;
            for(int j = 0; j<friends.length; j++){
                if(friendList[0].equals(friends[j])) indexWhoGive = j;
                else if(friendList[1].equals(friends[j])) indexWhoGiven = j;
            }
            giftsInfo[indexWhoGive][indexWhoGiven]++;
            giftsCount[indexWhoGive][1]++;
            giftsCount[indexWhoGiven][0]++;
        }

        for(int i = 0; i<N; i++){
            rateOfGift[i] = giftsCount[i][1] - giftsCount[i][0];
        }

        for(int i = 0; i<N; i++){
            for(int j = i+1; j<N; j++){
                if(giftsInfo[i][j] == giftsInfo[j][i]) {
                    if(rateOfGift[i] > rateOfGift[j]) willGivenGift[i]++;
                    else if(rateOfGift[i] < rateOfGift[j]) willGivenGift[j]++;
                } else if(giftsInfo[i][j] > giftsInfo[j][i]) willGivenGift[i]++;
                else if(giftsInfo[i][j] < giftsInfo[j][i]) willGivenGift[j]++;
            }
        }

        int max = -1;
        for(int i = 0; i<N; i++){
            max = Math.max(max, willGivenGift[i]);
        }

        return max;
    }


    public static void main(String[] args) {
        System.out.println(solution(new String[]{"muzi", "ryan", "frodo", "neo"}, new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}));
    }
}
