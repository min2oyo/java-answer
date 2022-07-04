import java.util.Scanner;

public class Game1 {   //주사위 게임
    public static void main(String[] args) {
        while(true) {
            System.out.println("==================");
            Scanner sc = new Scanner(System.in);

            //게임 시작
            System.out.println("주사위를 맞춰보세요^^");
            int user = sc.nextInt();                        //숫자 입력(사용자)
            int computer = (int) (Math.random() * 6) + 1;   //숫자 입력(컴퓨터)

            //게임 결과
            if (user == computer) {
                System.out.println("오! 맞았습니다!! (정답: " + computer + ")");
            } else {
                System.out.println("틀렸어요ㅜ (정답: " + computer + ")");
            }

            //게임 지속 여부
            System.out.println("---다시하기: 아무 숫자키 , 종료: 0");
            if (sc.nextInt() == 0) {System.out.println("게임을 종료합니다. 바이~"); break;}
        }
    }
}