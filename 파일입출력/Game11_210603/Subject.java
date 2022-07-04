//made by 진민

package Game11_210603;

public class Subject {
    private String name;
    private int kor;
    private int eng;
    private int mat;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    @Override
    public String toString() {
        return "name: " + name + ", kor: " + kor + ", eng: " + eng + ", mat: " + mat;
    }
}
