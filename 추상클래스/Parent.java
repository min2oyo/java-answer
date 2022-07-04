//made by 진민

package Game09_210531;

abstract class Parent{
    private String name;
    private int age;

    public Parent(String name, int age) { //생성자 오버로딩: 생성자와 이름은 같으나 빈손으로 오지 않음
        this.name = name;   //this: 현재 클래스의 필드를 가리킴 (this.name = private String name)
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {  //접근제어자(public): 모든 곳에서 호출 가능
        return "이름: " + name + " , 나이: " + age;
    }

    void say(String str) {    //접근제어자(default): 동일한 패키지 내에서만 호출 가능
        System.out.println(name + ": " + str);
    }

    public abstract void abs(int num1, int num2);    //추상클래스: 부모가 자신과 동시에 자식에게도 무조건 주며 부모의 강요로 꼭 써야함, 내용은 자식이 구성

}
