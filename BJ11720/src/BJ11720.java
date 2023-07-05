import java.util.Scanner;

public class BJ11720 {
    public static void main(String[] args) {
        /* 방법 1 : string으로 받은 뒤 char 배열로 변환 후 더하기 */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for(int i = 0; i < cNum.length; i++){
            sum += cNum[i] - '0';
        }
        System.out.print(sum);

        /* 방법 2 : 10으로 나눈 나머지와 몫 활용하기
        *  해당 문제에서는 사용 불가 WHY? 현재 입력 가능한 N의 범위가 1~100이므로 100자리까지 표현가능
        * 0~10의 99승까지 표현 가능한데 long 범위를 넘어서 버림
        * NumberFormatException 예외 출력으로 해당 방식으로는 풀 수 없음 */
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        long sNum = Long.parseLong(sc.next());
//        int sum = 0;
//        for(int i = 0; i<N-1; i++){
//            sum += sNum % 10;
//            sNum /= 10;
//        }
//        sum += sNum;
//        System.out.println(sum);
    }
}
