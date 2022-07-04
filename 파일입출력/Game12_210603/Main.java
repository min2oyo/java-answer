//edited by 진민 from someone(?)

package Game12_210603;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String file1 = "list.txt";
        Scanner sc = new Scanner(System.in);
        boolean isEnd = false;
        try {
            PrintWriter file = new PrintWriter(new FileOutputStream(file1));
        Controller1 controller1 = new Controller1();
        int a = 1;
        System.out.println("비행기 관리 프로그램");
        while (!isEnd){
            Air air = new Air();
            System.out.print("1.입력 2.출력 3.검색 4.종료 > ");
            int sel = sc.nextInt();
            switch (sel){
                case 1:
                     controller1.insert(air);
                     file.write(a+". ");
                     file.write("이름> "+ air.getName()+", 연락처: ");
                     file.write(air.getCreated()+", 주문: ");
                     file.write(air.getOrder()+", 가격: ");
                     file.write(air.getPrice()+", 매출 여부: ");
                     file.write(air.getExport());
                     file.println();
                     a++;
                    break;
                case 2:
                    controller1.select();
                    break;
                case 3:
                    controller1.search();
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    isEnd=true; break;
            }
        }
        file.close();
    }catch (Exception e){
            e.printStackTrace();
        }
    }
}
