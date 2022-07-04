//made by 진민

/* 주요내용
 - 주석에서 앞의 '-'은 하위메뉴를 나타냄
 - 과일클래스만 추가,수정하면 모두 자동으로 반영되어 유지보수가 수월
 - 구입목록에서 총액을 추가하여 알뜰한 소비 가능
*/

/* 변경사항
 - 21.05.29 개발 완료
 - 21.05.29 정영훈 님의 배열 인덱스의 [변수++]를 참고하여 [count];count++;에서 [count++]; 적용
 - 21.05.29 김민지 님의 절취선 참고
 - 21.05.29 구입목록에서 총액 구현
 - 21.05.30 정영훈 님의 과일클래스에서 생성자 설계를 참고하여 각 과일명(){super.setName; super.setPrice; ...}에서
            과일명(){super(name, price, ...)}로 변경
 - 21.05.30 이수지 님의 새 for문 주석 설명을 보고 구입목록에서 for(Fruit i : bought)로 변경
 - 21.05.30 for문에서 ';'이 하나인 것은 {} 제거 <- 실험 삼아
 - 21.05.30 (.toString) 표기 제거
 - 21.05.30 배열 fruits와 frName(과일명)이 중복이라 판단하여 frName 배열을 제거하고 기존 코드값은 fruits[].getName으로 변경
*/

package Game08_210528;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //과일클래스 가져오기, 가져온 후 모든 구성이 자동으로 변경 됨
        Fruit[] fruits = {
                new Apple(),
//                new Strawberry(),
//                new Melon(),
                new Banana(),
                new Orange(),
        };

        //변수
        int count = 0, full = 10, sumPrice = 0, sel;    //구입 수, 구입 최대값, 총액, 선택
        Fruit[] bought = new Fruit[full];               //구매한 과일

        //문구
        String strMain = "과일을 선택하세요";
        String[] strMenu = {".구입목록 ", ".과일검색 ", ".종료 "};   //메뉴
        String strBought = "구입했습니다";
        String strNotBought = "!더 이상 구입할 수 없습니다";
        String strBoughtMenu = "🍒🍒🍒🍒🍒🍒구입목록🍒🍒🍒🍒🍒🍒";
        String strNoBought = "!구입한 과일이 없습니다";
        String strSel = "🍌🍌검색할 과일을 선택하세요🍌🍌";
        String strNoNum = "!없는 번호입니다";
        String strExit = "종료합니다";
        String reply = ">>";

        //프로그램 시작
        while (true) {
            System.out.println("\n" + strMain + " (" + count + "/" + full + "개 구입)"); //메인 문구

            for (int i = 0; i < fruits.length; i++)     //과일 메뉴
                System.out.print((++i) + "." + fruits[--i].getName() + " ");
            for (int i = 0; i < strMenu.length; i++)    //기타 메뉴
                System.out.print((fruits.length + ++i) + strMenu[--i]);
            sel = sc.nextInt() - 1; //번호 선택
//      ----------------------------------------------------------------------
            if (sel >= 0 && sel < fruits.length) {  //과일 구입
                if (count == full) System.out.println(reply + strNotBought);
                else{
                    bought[count] = fruits[sel];
                    sumPrice += bought[count++].getPrice();
                    System.out.println(reply + fruits[sel].getName() + fruits[sel].getStrPs() + strBought);
                }
//      ----------------------------------------------------------------------
            } else if (sel == fruits.length) {    //구입목록
                if (count == 0) System.out.println(reply + strNoBought);
                else {
                    count = 0;
                    System.out.println("\n\t" + strBoughtMenu);
                    for (Fruit i : bought) if (i != null)
                        System.out.println("\t" + ++count + " - " + i);
                    System.out.println("\t" + reply + "총액: " + sumPrice);
                }
//      ----------------------------------------------------------------------
            } else if (sel == fruits.length + 1) {  //과일검색
                while (true) {
                    System.out.print("\n\t" + strSel + "\n\t");
                    for (int i = 0; i < fruits.length; i++)     //-과일 문구
                        System.out.print((++i) + "." + fruits[--i].getName() + " ");
                    sel = sc.nextInt() - 1; //-과일 선택
                    if (sel >= 0 && sel < fruits.length) {
                        System.out.println("\t" + reply + fruits[sel]);
                        break;
                    } else System.out.println("\t" + reply + strNoNum);  //-없는 번호 선택
                }
//      ----------------------------------------------------------------------
            } else if (sel == fruits.length + 2) {    //종료
                System.out.println(reply + strExit);
                break;
            } else System.out.println(reply + strNoNum);    //없는 번호 선택
        }
    }
}


