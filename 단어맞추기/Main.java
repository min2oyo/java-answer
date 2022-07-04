package stage.today15.a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VocaDTO vocaDTO;
        VocaDAO vocaDAO = new VocaDAO();

        while (true) {
            System.out.println("\n🎈🎈🎈 단어장 🎈🎈🎈");
            System.out.print("1.등록 2.출력 3.검색 4.수정 5.삭제 6.단어 맞추기 게임 7.종료");
            int input = sc.nextInt();
            if (input == 7) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            switch (input) {
                case 1:
                    vocaDAO.insert();
                    break;
                case 2:
                    vocaDAO.list();
                    break;
                case 3:
                    vocaDAO.search();
                    break;
                case 4:
                    vocaDAO.edit();
                    break;
                case 5:
                    vocaDAO.delete();
                    break;
                case 6:
                    vocaDAO.game();
                    break;
            }
        }
    }
}
