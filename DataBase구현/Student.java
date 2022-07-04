//made by 진민 (DTO)

package games.Game13_210611;

public class Student {
    private int stdNo;
    private String name;
    private String phNum;
    private String gender;
    private String regDate;

    public int getStdNo() {
        return stdNo;
    }

    public void setStdNo(int stdNo) {
        this.stdNo = stdNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhNum() {
        return phNum;
    }

    public void setPhNum(String phNum) {
        this.phNum = phNum;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regdate) {
        this.regDate = regdate;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
