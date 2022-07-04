//made by 진민
//본인은 자존심 있어 split 안 씀

/* 추가 연구할 것
 - name, kor 구하는 식을 하나의 반복문으로 구현해 볼 것
 - 유사 파일이 들어와도 오류없이 자동으로 구동이 가능할 것(과목 추가 등)
 */

package Game11_210603;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class Main { //성적 조회 프로그램
    public static void main(String[] args) {

        //변수
        HashMap<Integer, Subject> subHm = new HashMap<>();
        Subject sj; //Subject 클래스
        Scanner sc;

        int index = 1, sel; //번호, 선택
        int opNum;          //연산 값
        String div = ",";   //절단 기호
        String name, kor, eng, mat;

        //파일 불러오기
        try {
            FileReader fr = new FileReader("C:\\data.txt");
            sc= new Scanner(fr);

            while(sc.hasNextLine()) {
                String score = sc.nextLine();
                sj = new Subject();

                name = score.substring(0, score.indexOf(div));      //절단
                score = score.substring(score.indexOf(div) + 1);    //변수 = 절단한 나머지
                sj.setName(name);

                kor = score.substring(0, score.indexOf(div));
                score = score.substring(score.indexOf(div) + 1);
                sj.setKor(Integer.parseInt(kor));

                eng = score.substring(0, score.indexOf(div));
                sj.setEng(Integer.parseInt(eng));

                mat = score.substring(score.indexOf(div) + 1);
                sj.setMat(Integer.parseInt(mat));

                subHm.put(index, sj);   //HashMap에 저장
                index++;

            }
            fr.close();

            //프로그램 시작
            while (true){

                System.out.println("\n======학생 목록======");

                for (int i = 0; i < subHm.size(); i++){
                    System.out.println((i + 1) + ". " + subHm.get(i + 1).getName() + " ");
                }

                System.out.print("검색할 학생의 번호를 입력하세요: ");
                sel = new Scanner(System.in).nextInt();

                if (sel > 0 && sel <= subHm.size()) {
                    System.out.println();
                    System.out.println("이름: " + subHm.get(sel).getName());
                    System.out.println("국어: " + subHm.get(sel).getKor() + "점");
                    System.out.println("영어: " + subHm.get(sel).getEng() + "점");
                    System.out.println("수학: " + subHm.get(sel).getMat() + "점");
                    System.out.print("합계: ");
                    opNum = subHm.get(sel).getKor() + subHm.get(sel).getEng() + subHm.get(sel).getMat();
                    System.out.println(opNum + "점");
                    System.out.print("평균: ");
                    opNum = opNum / 3;
                    System.out.println(opNum + "점");
                    System.out.print("학점: ");
                    if (opNum >= 90) System.out.println("A학점");
                    else if (opNum >= 80) System.out.println("B학점");
                    else if (opNum >= 70) System.out.println("C학점");
                    else if (opNum >= 60) System.out.println("D학점");
                    else System.out.println("F학점");

                    System.out.print("\n목록으로(아무 숫자키): ");
                    sel = new Scanner(System.in).nextInt();
                } else{
                    System.out.println("없는 번호입니다. ");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
