package stage.today15.a;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Scanner;

public class VocaDAO {
    Connection conn;
    Scanner sc;
    StringBuilder sql;
    PreparedStatement pstmt;
    ResultSet rs;
    VocaDTO dto;
    HashMap<Integer, VocaDTO> hm = new HashMap<>();

    public void insert() {
        sc = new Scanner(System.in);
        System.out.print("추가할 단어를 입력하세요 > ");
        String eng = sc.next();
        System.out.print("단어의 뜻을 입력하세요 > ");
        String kor = sc.next();
        System.out.print("레벨을 입력하세요 > ");
        int lev = sc.nextInt();
        try {
            conn = Dbconn.getConnection();
            sql = new StringBuilder();
            sql.append("INSERT INTO tb_word (w_eng, w_kor, w_level) VALUES(?, ?, ?)");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, eng);
            pstmt.setString(2, kor);
            pstmt.setInt(3, lev);
            int result = pstmt.executeUpdate();
            if (result >= 1) System.out.println("단어 등록 성공");
            else System.out.println("단어 등록 실패");

            Dbconn.dbclose();
            pstmt.close();
            pstmt = null;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void list() {
        try {
            conn = Dbconn.getConnection();
            sql = new StringBuilder();
            sql.append("SELECT w_eng, w_kor, w_level, w_datetime FROM tb_word order by w_eng asc");
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String eng = rs.getString("w_eng");
                String kor = rs.getString("w_kor");
                int lev = rs.getInt("w_level");
                String datetime = rs.getString("w_datetime");
                System.out.println(eng + " : " + kor + " (" + lev + ", " + datetime + ")");
            }
            Dbconn.dbclose();
            rs.close();
            rs = null;
            pstmt.close();
            pstmt = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void search() {
        sc = new Scanner(System.in);
        System.out.print("검색할 단어를 입력하세요 > ");
        String word = sc.next();
        try {
            boolean isFind = false;
            conn = Dbconn.getConnection();
            sql = new StringBuilder();
            sql.append("SELECT w_eng, w_kor, w_level, w_datetime FROM tb_word WHERE w_kor=?");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, word);
            rs = pstmt.executeQuery();
//            if (!rs.next()) { // 하나만 찾을떄는 이 방법 사용해도 무방.
//                System.out.println("찾는 단어가 없습니다.");
//            } else {
//                    String eng = rs.getString("w_eng");
//                    String kor = rs.getString("w_kor");
//                    int lev = rs.getInt("w_level");
//                    String datetime = rs.getString("w_datetime");
//                    System.out.println(eng + " : " + kor + " (" + lev + ", " + datetime + ")");
//            }
            while (rs.next()) {
                isFind = true;
                String eng = rs.getString("w_eng");
                String kor = rs.getString("w_kor");
                int lev = rs.getInt("w_level");
                String datetime = rs.getString("w_datetime");
                System.out.println(eng + " : " + kor + " (" + lev + ", " + datetime + ")");
            }
            if (!isFind) System.out.println("찾는 단어가 없습니다.");
            Dbconn.dbclose();
            rs.close();
            rs = null;
            pstmt.close();
            pstmt = null;

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void edit() {
        sc = new Scanner(System.in);
        System.out.print("수정할 단어를 입력하세요 > ");
        String eng = sc.next();
        System.out.print("단어의 뜻을 입력하세요 > ");
        String kor = sc.next();
        System.out.print("레벨을 입력하세요 > ");
        int lev = sc.nextInt();
        try {
            conn = Dbconn.getConnection();
            sql = new StringBuilder();
            sql.append("UPDATE tb_word SET w_kor=?, w_level=? WHERE w_eng=?");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, kor);
            pstmt.setInt(2, lev);
            pstmt.setString(3, eng);
            int result = pstmt.executeUpdate();

            if (result >= 1) System.out.println("단어 수정 성공");
            else System.out.println("단어 수정 실패");

            Dbconn.dbclose();
            pstmt.close();
            pstmt = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        sc = new Scanner(System.in);
        System.out.print("삭제할 단어를 입력하세요 > ");
        String word = sc.next();
        try {
            conn = Dbconn.getConnection();
            sql = new StringBuilder();
            sql.append("DELETE FROM tb_word WHERE w_eng=?");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, word);
            int result = pstmt.executeUpdate();
            if(result >= 1 ) System.out.println("단어 삭제 성공!");
            else System.out.println("단어 삭제 실패!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void game() {
        sc = new Scanner(System.in);
        try {
            conn = Dbconn.getConnection();
            sql = new StringBuilder();
            sql.append("SELECT w_eng, w_kor, w_level, w_datetime FROM tb_word order by w_eng asc");
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
//--------------------------------------------------------------------------------------------------------
            int i = 0;      //데이터 범위 지정
            while (rs.next()) { //HashMap에 저장
                dto = new VocaDTO(
                        rs.getString("w_eng"),
                        rs.getString("w_kor"),
                        rs.getInt("w_level")
                );
                hm.put(++i, dto);
            }
            Dbconn.dbclose();
            rs.close();
            rs = null;
            pstmt.close();
            pstmt = null;
            int score = 0;  //점수
            while (true) {  //게임 시작
                int random = (int) (Math.random() * hm.size()) + 1; //랜덤 생성
                for (Integer j : hm.keySet()) {
                    if (j == random) {
                        System.out.print("(" + score + "/10 난이도" + hm.get(j).getLev() + ") " + hm.get(j).getEng() + ": ");
                        if (sc.next().equals(hm.get(j).getKor())) {
                            System.out.println("정답");
                            score++;
                            break;
                        } else {
                            System.out.println("땡");
                            break;
                        }
                    }
                }
                if (score == 10) {
                    System.out.println("(" + score + "/10)" + "모두 맞췄습니다!!");
                    break;
                }
            }
//--------------------------------------------------------------------------------------------------------
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
