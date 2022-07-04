//made by 진민

import java.util.Scanner;

public class Game2_210525 { //사칙연산 게임
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //변수 설정1
        String opStr = "";  //사칙연산 기호
        int cor = 0;        //정답
        int i = 0;          //점수

        while (i < 10) {

            //변수 설정2
            int num1 = (int) (Math.random() * 10) + 1;  //첫 번째 숫자
            int num2 = (int) (Math.random() * 10) + 1;  //두 번째 숫자
            int opNum = (int) (Math.random() * 4) + 1;  //사칙연산 넘버링

            //사칙연산 설정
            switch (opNum) {
                case 1:
                    opStr = " + ";
                    cor = num1 + num2;
                    break;
                case 2:
                    opStr = " - ";
                    cor = num1 - num2;
                    break;
                case 3:
                    opStr = " * ";
                    cor = num1 * num2;
                    break;
                case 4:
                    opStr = " / ";
                    cor = num1 / num2;
                    break;
                default:
                    System.out.println("알 수 없는 오류가 발생했습니다.");
            }

            //게임 시작
            System.out.println("==============================");
            System.out.println("나눗셈일 경우 몫만 입력하세요 (점수: " + i + "/10점)");
            System.out.print(num1 + opStr + num2 + " = ");

            //답 입력
            if (sc.nextInt() == cor) {
                System.out.println("정답이에요~");
                i++;
            } else System.out.println("틀렸어요ㅜ 다시!!");

            //게임 종료
            if (i == 10) {
                System.out.println("모두 맟췄어요, 똑똑하시네요~! (점수: " + i + "/10점)");
                System.out.println("다시하기: 1, 종료: 아무 숫자키");
                if (sc.nextInt() == 1) {
                    i = 0;
                    continue;
                }
            }
        }
        System.out.println("게임을 종료합니다. 바이~");
    }
}
