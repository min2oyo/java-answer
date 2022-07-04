import java.util.Scanner;

public class Game2 {	//가위바위보 게임
    public static void main(String[] args) {
        while(true) {
            System.out.println("==================");
            Scanner sc = new Scanner(System.in);

            //변수 설정
            String name1 = "나", name2 = "컴퓨터";          //유저 설정
            String one = "가위", two = "바위", thr = "보";  //가위바위보 설정
            String hand1 = "", hand2 = "";                //가위바위보 결정 설정

            //게임 시작
            System.out.println(one + ": 1");
            System.out.println(two + ": 2");
            System.out.println(thr + ": 3");
            System.out.println(">>>시작, " + one + two + "~ (종료: 4)");
            int user = sc.nextInt();			            //name1 입력
            if (user == 4) {System.out.println("게임을 종료합니다. 바이~"); break;}
            int computer = (int) (Math.random() * 3) + 1;   //name2 입력

            //가위바위보 문자화
            if (user == 1) hand1 = one;
            if (user == 2) hand1 = two;
            if (user == 3) hand1 = thr;
            if (computer == 1) hand2 = one;
            if (computer == 2) hand2 = two;
            if (computer == 3) hand2 = thr;
            if (computer < user) computer += 3; //숫자 차이 맞춤
            String result = "(" + name1 + ": " + hand1 + ", " + name2 + ": " + hand2 + ")";	//결과 변수 할당

            //게임 결과
            if (user != 1 && user != 2 && user != 3) {
                System.out.println("잘못냈어요~" + result);
            } else if (user == computer) {
                System.out.println("비겼습니다!! " + result);
            } else if (computer - user == 1) {
                System.out.println("졌어요ㅜ " + result);
            } else {
                System.out.println("오, 이겼어요!! " + result);
            }

            //게임 지속 여부
            System.out.println("---다시하기: 아무 숫자키 , 종료: 4");
            if (sc.nextInt() == 4) {System.out.println("게임을 종료합니다. 바이~"); break;}
        }
    }
}
