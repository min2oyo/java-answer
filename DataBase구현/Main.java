//made by 진민

/* 프로그램 특징
 - 유지보수가 수월하도록 제작에 신경 씀
 - 입력 오류시 그 상황에 맞는 오류문이 출력됨(문자수, 학번중복, 숫자에 문자입력 등)
 - StringBuilder는 굳이 사용 안 함
 - 목록은 깔끔하게 출력되며 오름차순으로 나타남
 - 성별은 남자, 여자로만 입력 받으며 숫자 선택으로 등록
 */

/* 변경사항
 - 21.06.13 개발완료
 */

package games.Game13_210611;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //객체
        Controller ctr = new Controller();  //DAO

        //프로그램 시작
        while (true) {
            ctr.sc = new Scanner(System.in);
            try {
                System.out.println("\n======= 학생 관리 프로그램 =======");
                System.out.print("1." + ctr.mn1 + " 2." + ctr.mn2 + " 3." + ctr.mn3 + " 4." + ctr.mn4 + " 5.종료  ");
                ctr.sel = ctr.sc.nextInt();

                if (ctr.sel == 1) {
                    System.out.println(">>학생을 등록합니다. ");
                    ctr.insert();
                } else if (ctr.sel == 2) {
                    System.out.println(">>학생 목록을 봅니다. ");
                    ctr.select();
                } else if (ctr.sel == 3) {
                    System.out.println(">>학생정보를 수정합니다. ");
                    ctr.update();
                } else if (ctr.sel == 4) {
                    System.out.println(">>학생정보를 삭제합니다. ");
                    ctr.delete();
                } else if (ctr.sel == 5) {
                    System.out.println(">>종료합니다. ");
                    break;
                } else System.out.println(">>!없는 번호입니다.");
            } catch (InputMismatchException num) {
                System.out.println(">>!알맞은 숫자로 입력하세요. ");
            }
        }

    }
}
