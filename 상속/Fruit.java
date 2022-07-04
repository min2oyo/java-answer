//made by 진민
//Q. set, get은 일반적으로 다 써주는 편인지 궁금?

package Game08_210528;

public class Fruit {

    private String name;
    private String strPs;
    private int price;
    private String color;
    private String origin;

    public Fruit(String name, String strPs, int price, String color, String origin) {
        this.name = name;
        this.strPs = strPs;
        this.price = price;
        this.color = color;
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public String getStrPs() {
        return strPs;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ": " + price + ", "  + color + ", "  + origin;
    }
}
