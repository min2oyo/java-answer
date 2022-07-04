//made by 진민

public class Game1_210526 {    //로또 프로그램
    public static void main(String[] args) {

        //로또 생성
        int[] num = new int[6];
        for (int i = 0; i < num.length; i++){
            num[i] = (int)(Math.random() * 45) + 1;
            for (int j = 0; j < i; j++){
                if (num[i] == num[j]){
                    i--;
                    break;
                }
            }
        }

        //오름차순 정렬
        int temp = 0;
        for (int i = 0; i < num.length - 1; i++){
            for (int j = i + 1; j < num.length; j++){
                if (num[i] > num[j]) {
                    temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }

        //오름차순 정렬 출력
        for (int i = 0; i < num.length; i++){
            System.out.print(num[i] + "  ");
        }
    }
}
