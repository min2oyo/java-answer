package stage.today15.a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VocaDTO vocaDTO;
        VocaDAO vocaDAO = new VocaDAO();

        while (true) {
            System.out.println("\nπππ λ¨μ΄μ₯ πππ");
            System.out.print("1.λ±λ‘ 2.μΆλ ₯ 3.κ²μ 4.μμ  5.μ­μ  6.λ¨μ΄ λ§μΆκΈ° κ²μ 7.μ’λ£");
            int input = sc.nextInt();
            if (input == 7) {
                System.out.println("νλ‘κ·Έλ¨μ μ’λ£ν©λλ€.");
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
