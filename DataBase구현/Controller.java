//made by 진민 (DAO)

/* SQL문
 - 등록: insert into T (F, ..) values (V, ..);
 - 목록: select F from T where F = V;
 - 수정: update T set F = V where F = V;
 - 삭제: delete from T where F = V;
 */

package games.Game13_210611;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeSet;

public class Controller {

    //변수
    Student std;    //DTO
    Scanner sc;

    String mn1 = "등록", mn2 = "목록", mn3 = "수정", mn4 = "삭제", num; //메뉴
    long sel;       //메뉴 선택
    boolean chk;    //중복검사
    int result;     //sql 등록 결정

    void newObj() { //'실행' 메소드에 사용
        std = new Student();
        sc = new Scanner(System.in);
        result = 0;
    }

//    ------------------------------------------------------------------------------------------------

    //DB서버
    private String student = "student"; //*테이블 (자바필드명 = "서버필드명")
    private String stdNo = "stdNo";     //학번
    private String name =  "name";      //이름
    private String phNum = "phNum";     //연락처
    private String gender = "gender";   //성별
    private String regDate = "regDate"; //등록일
    Connection conn;
    Statement stmt;
    {
        try {
            conn = DB_Server.getConnection();
            stmt = conn.createStatement();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

//    ------------------------------------------------------------------------------------------------

    //실행
    void insert() { //1.등록
        num = mn1;
        newObj();
        chkStdNo();
        if (std.getStdNo() == 0) System.out.println("\t>>메뉴로 이동합니다.");
        else {
            inInfo();
            try {   //서버 등록
                result = stmt.executeUpdate(
                        "insert into " +
                                student + " (" +    //테이블
                                stdNo + ", " +      //필드
                                name + ", " +
                                phNum + ", " +
                                gender + ") " +
                                "values ('" +
                                std.getStdNo() + "', '" +   //값
                                std.getName() + "', '" +
                                std.getPhNum() + "', '" +
                                std.getGender() + "');"
                );
                if (result >= 1) System.out.println("\n>>학생정보가 등록되었습니다. ");
                else System.out.println("\n>>!학생정보 등록에 실패했습니다. ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void select() {  //2.목록
        num = mn2;
        TreeSet<String> ts = new TreeSet<>();   //오름차순 저장소 호출
        try{
            ResultSet rs = stmt.executeQuery("select * from " + student + ";"); //DB 불러오기
            while (rs.next()){  //저장
                ts.add(
                        "학번: " + String.format("%05d", rs.getInt(stdNo)) + "\t" +
                        "이름: " + String.format("%4s", rs.getString(name))  + "\t  " +
                        "연락처: " + rs.getString(phNum) + "\t" +
                        "성별: " + rs.getString(gender) + "\t" +
                        "등록일: " + rs.getString(regDate).substring(0,10)
                );
            }
            System.out.println();
            int cnt = 0;
            for (String i : ts){    //출력
                System.out.printf("\t%3s - " + i + "\n", ++cnt);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void update() {  //3.수정
        num = mn3;
        newObj();
        chkStdNo();
        if (std.getStdNo() == 0) System.out.println("\t>>메뉴로 이동합니다.");
        else{
            inInfo();
            try{    //서버 등록
                result = stmt.executeUpdate("update " + student + " set " +
                        "name = '" + std.getName()
                        + "', phNum = '" + std.getPhNum()
                        + "', gender = '" + std.getGender()
                        + "' where stdNo = " + std.getStdNo()
                + ";");
                if(result >= 1) System.out.println("\n>>학생정보가 변경되었습니다. ");
                else System.out.println("\n>>!학생정보 변경에 실패했습니다. ");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    void delete() {  //4.삭제
        num = mn4;
        newObj();
        chkStdNo();
        try {
            result = stmt.executeUpdate(
                    "delete from " + student + " where stdNo = " + std.getStdNo() + ";"
            );
            if (std.getStdNo() == 0) System.out.println("\t>>메뉴로 이동합니다.");
            else if (result >= 1) System.out.println("\n>>" + std.getStdNo() + "학번 학생정보를 삭제했습니다. ");
            else System.out.println("\n>>!" + std.getStdNo() + "학번 학생정보 삭제를 실패했습니다. ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    ------------------------------------------------------------------------------------------------

    //기능
    void chkStdNo() {   //학번 중복검사
        while (true) {
            try{
                chk = false;
                System.out.print("\n\t" + num + "할 학번을 입력하세요(숫자5자 이내, 메뉴:0): ");   std.setStdNo(sc.nextInt());
                if (std.getStdNo() == 0) break;
                else if (std.getStdNo() >= Math.pow(10,5)) System.out.println("\t>>!학번 길이를 확인해주세요. ");
                else {
                    Connection conn = DB_Server.getConnection();
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("select " + stdNo + " from " + student + ";");
                    while (rs.next()) {
                        if (rs.getInt(stdNo) == std.getStdNo()) { //DB서버와 비교
                            chk = true;
                            break;
                        }
                    }
                    if (sel == 1) {
                        if (chk) System.out.println("\t>>!이미 등록된 학번입니다. ");
                        else break;
                    } else {
                        if (chk) break;
                        else System.out.println("\t>>!없는 학번입니다. ");
                    }
                }
            } catch (InputMismatchException i){
                System.out.println("\t>>!숫자로 입력하세요. ");
                sc = new Scanner(System.in);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void inInfo() {  //정보 입력
        while (true) {
            System.out.print("\n\t이름을 입력하세요(4자 이내): ");
            std.setName(sc.next());
            if (std.getName().length() < 5) break;
            else System.out.println("\t>>!이름 길이를 확인해주세요. ");
        }
        while (true) {
            try {
                System.out.print("\n\t연락처를 입력하세요(-없이 숫자11자): ");  std.setPhNum(sc.next());
                if (std.getPhNum().length() == 11) {
                    std.setPhNum(String.format("%011d", Long.parseLong(std.getPhNum())));
                    std.setPhNum(
                            std.getPhNum().substring(0, 3) + "-" +
                            std.getPhNum().substring(3, 7) + "-" +
                            std.getPhNum().substring(7)
                    );
                    break;
                } else {
                    Long.parseLong(std.getPhNum());
                    System.out.println("\t>>!연락처 길이를 확인해주세요");
                }
            } catch (NumberFormatException str) {
                System.out.println("\t>>!숫자로 입력하세요. ");
                sc = new Scanner(System.in);
            }
        }
        while (true) {
            System.out.print("\n\t성별을 입력하세요(남자:1, 여자:2): ");
            std.setGender(sc.next());
            if (std.getGender().equals("1") || std.getGender().equals("2")) break;
            else System.out.println("\t>>!알맞은 번호를 입력해주세요.");
        }
    }

}
