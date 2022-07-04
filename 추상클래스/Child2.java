//made by 진민

package Game09_210531;

public class Child2 extends Parent {

    public Child2(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "둘째 - " + super.toString();
    }

    @Override
    void say(String str) {
        System.out.println(getName() + ": " + str);
    }

    public void abs(int num1, int num2){
        System.out.println(getName() + ": 귀여미");
    }
}
