//made by 진민

package Game09_210531;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Parent ps = new Parent("볼펜", 30) {
            @Override
            public void abs(int num1, int num2) {
                System.out.println(getName() + ": " +  num1 + " + " + num2 + "은?");
            }
        };

        Parent[] ch = new Parent[2];
        ch[0] = new Child1("기억", 6);
        ch[1] = new Child2("니은", 5);

        final int wakeTime = 6; //final 키워드: 무슨 일이 있어도 그 자리에만 있으며 세상 변하지 않는 값
        final String strMain = "[다음 이야기가 궁금하다면 '0'을 입력]";

        System.out.println(strMain);
        System.out.println("제목: Hello? ");

        if (sc.nextInt() == 0){
            System.out.println("------------");
            System.out.println("등장인물\n" + "부모 - " + ps + "\n" + ch[0] + "\n" + ch[1]);
        }
        if (sc.nextInt() == 0){
            System.out.println("------------");
            System.out.println("현재시간: " + wakeTime + "시");
        }
        if (sc.nextInt() == 0) ps.say("얘들아");
        if (sc.nextInt() == 0) ch[0].say("zz"); ch[1].say("..");
        if (sc.nextInt() == 0) ps.say("일어나!!");
        if (sc.nextInt() == 0) ch[0].say("zz"); ch[1].say("zzzzzz");
        if (sc.nextInt() == 0) System.out.println("이야기1 끝\n------------");
        if (sc.nextInt() == 0) ps.say("얘들아");
        if (sc.nextInt() == 0) ps.abs(1,1);
        if (sc.nextInt() == 0) ch[0].abs(2,2);
        if (sc.nextInt() == 0) ch[1].abs(0,0);
        if (sc.nextInt() == 0) ps.say("..\n");
        if (sc.nextInt() == 0) ps.say("이야기2 끝\n------------");
    }
}
