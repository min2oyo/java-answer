//made by 진민

package Game09_210531;

public class Child1 extends Parent {    //상속: Parent클래스와 연결되었으며 그 모든 기능을 물려 받음

    public Child1(String name, int age) {   //생성자: 객체를 호출 받을 때 반드시 실행되는 메소드
        super(name, age);   //super: 부모의 변수를 사용
    }

    @Override
    public String toString() {
        return "첫째 - " + super.toString();
    }

    @Override   //메소드 오버라이딩: 부모클래스가 가지고 있는 메소드명을 복제해서 씀
    void say(String str) {
        System.out.println(getName() + ": " + str);
    }

    public void abs(int num1, int num2){
        System.out.println(getName() + ": 귀요미");
    }
}
