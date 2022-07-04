//made by 진민

import java.util.Scanner;

public class Game3_210525 { //꼰대 테스트 게임
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //변수설정
        int sel, go;    //선택, 이동
        String choice = "   1. 예  2. 아니오";
        String ins = "선택: ";
        String result1 = "당신은 꼰대입니다. ";
        String result2 = "당신은 꼰대가 아닙니다. 안심하세요.";

        //게임 시작
        while (true){
            System.out.printf("\n" + "=========================");
            System.out.printf("\n" + "'라떼는 말야~'등의 말을 한다." + "\n" + choice + "\n" + ins);
            sel = sc.nextInt();
            if (sel == 1) {go = 2; break;}
            if (sel == 2) {go = 1; break;}
            else System.out.println(">>잘못 선택하였습니다. ");
        }
        while (true){
            switch (go){
                case 1:
                    while (true){
                        System.out.printf("\n" + "사람들의 애로사항을 잘 공감하고 경청한다." + "\n" + choice + "\n" + ins);
                        sel = sc.nextInt();
                        if (sel == 1) {go = 3; break;}
                        if (sel == 2) {go = 2; break;}
                        else System.out.println(">>잘못 선택하였습니다. ");;
                    }
                    break;
                case 2:
                    while (true){
                        System.out.printf("\n" + "잔소리를 많이 한다." + "\n" + choice + "\n" + ins);
                        sel = sc.nextInt();
                        if (sel == 1) {go = 4; break;}
                        if (sel == 2) {go = 3; break;}
                        else System.out.println(">>잘못 선택하였습니다. ");;
                    }
                    break;
                case 3:
                    while (true){
                        System.out.printf("\n" + "'미안한데 말야~', '무슨뜻인지 아는데~' 같은 말을 앞에 붙인다.'" + "\n" + choice + "\n" + ins);
                        sel = sc.nextInt();
                        if (sel == 1) {go = 4; break;}
                        if (sel == 2) {go = 7; break;}
                        else System.out.println(">>잘못 선택하였습니다. ");;
                    }
                    break;
                case 4:
                    while (true){
                        System.out.printf("\n" + "문제를 해결할 때 직급이나 나이를 내세운다. " + "\n" + choice + "\n" + ins);
                        sel = sc.nextInt();
                        if (sel == 1) {go = 5; break;}
                        if (sel == 2) {go = 7; break;}
                        else System.out.println(">>잘못 선택하였습니다. ");;
                    }
                    break;
                case 5:
                    while (true){
                        System.out.printf("\n" + "아랫 사람의 의견을 잘 듣는다" + "\n" + choice + "\n" + ins);
                        sel = sc.nextInt();
                        if (sel == 1) {go = 7; break;}
                        if (sel == 2) {go = 6; break;}
                        else System.out.println(">>잘못 선택하였습니다. ");;
                    }
                    break;
                case 6:
                    while (true){
                        System.out.printf("\n" + "'예스맨'이 좋다" + "\n" + choice + "\n" + ins);
                        sel = sc.nextInt();
                        if (sel == 1) {go = 8; break;}
                        if (sel == 2) {go = 7; break;}
                        else System.out.println(">>잘못 선택하였습니다. ");;
                    }
                    break;
                case 7:
                    while (true){
                        System.out.printf("\n" + "옳지 않은 일이라도 윗사람 의견이라면 무조건 따른다" + "\n" + choice + "\n" + ins);
                        sel = sc.nextInt();
                        if (sel == 1) {go = 8; break;}
                        if (sel == 2) {
                            System.out.printf("\n" + result2);  go = 0; break;}
                        else System.out.println(">>잘못 선택하였습니다. ");;
                    }
                    break;
                case 8:
                    while (true){
                        System.out.printf("\n" + "일이 잘 되었을 떄보다 잘못 되었을 때 내가 책임을 안 지는 게 더 중요하다" + "\n" + choice + "\n" + ins);
                        sel = sc.nextInt();
                        if (sel == 1) {
                            System.out.printf("\n" + result1); go = 0; break;}
                        if (sel == 2) {
                            System.out.printf("\n" + result2); go = 0; break;}
                        else System.out.println(">>잘못 선택하였습니다. ");;
                    break;
                    }
                default:
            }

            //게임 종료
            if (go == 0) break;
        }
    }
}
