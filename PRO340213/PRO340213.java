import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class PRO340213 {
    static LocalTime videoTime;
    static LocalTime posTime;
    static LocalTime opStartTime;
    static LocalTime opEndTime;

    public static String solution(String video_len, String pos, String op_start, String op_end,
                                  String[] commands){
        String[] videoLen = video_len.split(":");
        String[] posSplit = pos.split(":");
        String[] opStart = op_start.split(":");
        String[] opEnd = op_end.split(":");

        videoTime = getTime(videoLen);
        posTime = getTime(posSplit);
        opStartTime = getTime(opStart);
        opEndTime = getTime(opEnd);

        opSkip();

        for(String s : commands){
            switch (s){
                case "prev":
                    moveToPrev();
                    break;
                case "next":
                    moveToNext();
                    break;
            }

            opSkip();
        }

        return posTime.format(DateTimeFormatter.ofPattern("mm:ss"));
    }

    private static void moveToPrev(){
        int min = posTime.getMinute();
        int sec = posTime.getSecond();

        if(min == 0 && sec<10){
            posTime = LocalTime.of(0,0,0);
            return;
        }

        posTime = posTime.minusSeconds(10);
    }

    private static void moveToNext(){
        posTime = posTime.plusSeconds(10);

        if(posTime.isAfter(videoTime)){
            posTime = videoTime;
        }
    }
    private static LocalTime getTime(String[] split){
        int min = Integer.parseInt(split[0]);
        int sec = Integer.parseInt(split[1]);

        return LocalTime.of(0, min, sec);
    }

    private static void opSkip(){
        if(!posTime.isBefore(opStartTime) && !posTime.isAfter(opEndTime)){
            posTime = opEndTime;
        }
    }
    public static void main(String[] args) {

        System.out.println(
                solution("34:33", "13:00", "00:55", "02:55", new String[]{"next", "prev"}));
        System.out.println(
                solution("10:55", "00:05", "00:15", "06:55", new String[]{"prev", "next", "next"}));
        System.out.println(solution("07:22", "04:05", "00:15", "04:07", new String[]{"next"}));
        System.out.println(solution("30:00", "29:55", "01:00", "01:30", new String[]{"next"}));
    }
}
