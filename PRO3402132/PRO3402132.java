class PRO3402132 {
    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";

        int videoLengthMin = Integer.parseInt(video_len.substring(0,2));
        int videoLengthSec = Integer.parseInt(video_len.substring(3));

        int posMin = Integer.parseInt(pos.substring(0,2));
        int posSec = Integer.parseInt(pos.substring(3));

        int opStartMin = Integer.parseInt(op_start.substring(0,2));
        int opStartSec = Integer.parseInt(op_start.substring(3));

        int opEndMin = Integer.parseInt(op_end.substring(0,2));
        int opEndSec = Integer.parseInt(op_end.substring(3));

        if(isOp(opStartMin, opStartSec, opEndMin, opEndSec, posMin, posSec)){
            posMin = opEndMin;
            posSec = opEndSec;
        }

        for(int i = 0; i<commands.length; i++){
            if(commands[i].equals("next")){
                // 1. 10초 추가시 변화
                if(posSec + 10 >= 60) {
                    posMin++;
                    posSec = posSec + 10 - 60;
                }
                else {
                    posSec += 10;
                }
                // 추가한 시간이 영상보다 긴 경우
                if(posMin > videoLengthMin || (posMin == videoLengthMin && posSec > videoLengthSec)) {
                    posMin = videoLengthMin;
                    posSec = videoLengthSec;
                }
            }
            else if(commands[i].equals("prev")){
                if(posSec - 10 < 0){
                    posMin--;
                    if(posMin < 0){
                        posMin = 0;
                        posSec = 0;
                    }
                    else{
                        posSec = posSec - 10 + 60;
                    }
                }
                else {
                    posSec -= 10;
                }
            }

            if(isOp(opStartMin, opStartSec, opEndMin, opEndSec, posMin, posSec)){
                posMin = opEndMin;
                posSec = opEndSec;
            }
        }

        String posMinStr = (posMin < 10) ? "0" + posMin : String.valueOf(posMin);
        String posSecStr = (posSec < 10) ? "0" + posSec : String.valueOf(posSec);

        answer = posMinStr + ":" + posSecStr;

        return answer;
    }

    public static boolean isOp(int opStartMin, int opStartSec, int opEndMin, int opEndSec, int posMin, int posSec){
        if(posMin > opStartMin && posMin < opEndMin){
            return true;
        }
        else if(posMin == opStartMin && opStartMin == opEndMin){
            if(posSec > opStartSec && posSec < opEndSec) return true;
        }
        else if(posMin == opStartMin && posSec >= opStartSec){
            return true;
        }
        else if(posMin == opEndMin && posSec <= opEndSec) return true;
        return false;
    }
    public static void main(String[] args) {
//        System.out.println(
//                solution("34:33", "13:00", "00:55", "02:55", new String[]{"next", "prev"}));
//        System.out.println(
//                solution("10:55", "00:05", "00:15", "06:55", new String[]{"prev", "next", "next"}));
//        System.out.println(solution("07:22", "04:05", "00:15", "04:07", new String[]{"next"}));
//        System.out.println(solution("30:00", "29:55", "01:00", "01:30", new String[]{"next"}));
        System.out.println(solution("34:33", "09:50", "10:00", "13:00", new String[]{"next", "next", "next", "prev"}));
    }
}