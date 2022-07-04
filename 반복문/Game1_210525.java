//made by 진민

import java.util.Scanner;

public class Game1_210525 { //가위바위보 게임
    public static void main(String[] args) {
        while(true) {
            System.out.println("==================");
            Scanner sc = new Scanner(System.in);

            //변수 설정
            String name1 = "나", name2 = "컴퓨터";          //유저 설정
            String one = "가위", two = "바위", thr = "보";  //가위바위보 설정
            String hand1 = "", hand2 = "";                //가위바위보 결정 설정

            //게임 시작
            System.out.println("이기면 집 간다");
            System.out.println(one + ": 1, " + two + ": 2, " + thr + ": 3");
            System.out.print(">>>시작! " + one + two + ": ");
            int user = sc.nextInt();			            //name1 입력
            int computer = (int) (Math.random() * 3) + 1;   //name2 입력

            //가위바위보 가공
            switch (user){
                case 1: hand1 = one; break;
                case 2: hand1 = two; break;
                case 3: hand1 = thr; break;
                default: System.out.println("알 수 없는 오류가 발생했습니다.");
            }
            switch (computer){
                case 1: hand2 = one; break;
                case 2: hand2 = two; break;
                case 3: hand2 = thr; break;
                default: System.out.println("알 수 없는 오류가 발생했습니다.");
            }
            if (computer < user) computer += 3; //숫자 간격 맞춤

            //게임 결과
            System.out.println(name1 + ": " + hand1);
            System.out.println(name2 + ": " + hand2);
            System.out.print(">>>");
            if (user != 1 && user != 2 && user != 3) {
                System.out.println("잘못냈어요~ 다시");
            } else if (user == computer) {
                System.out.println("비겼습니다!! 다시");
            } else if (computer - user == 1) {
                System.out.println("졌어요ㅜ 다시");
            } else {
                System.out.println("와우 이겼어요!! 집에 갑니당. 바이~");
                break;
            }
        }
    }
}
