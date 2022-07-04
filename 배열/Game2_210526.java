//made by 진민

import java.util.Scanner;

public class Game2_210526 {    //주민등록번호 유효성 검사
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //변수 설정
        String rsNum;   //주민번호
        int opNum = 0;  //연산 결과
        int[] test = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};  //유효성 확인

        //주민번호 입력
        while (true){   //13자리 외 무한루프
            System.out.print("주민번호 13자리를 입력하세요: ");
            rsNum = sc.next();
            if (rsNum.length() == 13) break;
        }int lastNum = Integer.parseInt(rsNum.substring(12)); //주민번호 마지막 값

        //연산
        for (int i = 0; i < 12; i++){
            opNum += Integer.parseInt(rsNum.substring(i, i+1)) * test[i];   //곱하고 더함
        }opNum = (11 - (opNum % 11)) % 10; //일의 자리값 추출

        //결과
        if (lastNum == opNum) System.out.println("주민번호는 정상입니다. ");
        else System.out.println("주민번호는 가짜입니다. ");
    }
}
