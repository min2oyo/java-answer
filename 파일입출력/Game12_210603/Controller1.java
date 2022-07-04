//edited by 진민 from someone(?)

package Game12_210603;

import java.util.HashMap;
import java.util.Scanner;

public class Controller1 {
    Scanner sc ;
    HashMap<String, Air> cafeHashMap;
    Controller1(){
        cafeHashMap = new HashMap<>();
    }
    public void insert(Air air){
        int a=0;
        sc= new Scanner(System.in);
        System.out.print("비행기명을 입력하세요: ");
        String name = sc.next();
        air.setName(name);
        System.out.print("주문명을 입력하세요: ");
        String order = sc.next();
        air.setOrder(order);
        System.out.print("가격을 입력하세요: ");
        String price = sc.next();
        air.setPrice(price);
        System.out.print("테이크아웃 여부를 입력하세요 > ");
        String takeout = sc.next();
        air.setExport(takeout);

        cafeHashMap.put(name, air);
    }
    public void select(){
        for (String key:cafeHashMap.keySet()){
            System.out.println("비행기명: "+cafeHashMap.get(key).getName());
            System.out.println("제조일: "+cafeHashMap.get(key).getCreated());
            System.out.println("주문: "+cafeHashMap.get(key).getOrder());
            System.out.println("가격 : "+cafeHashMap.get(key).getPrice());
            System.out.println("매출 여부 : "+cafeHashMap.get(key).getExport());
            System.out.println("******************************************");
            System.out.println();
        }

    }
    public void search(){
        sc=new Scanner(System.in);
        System.out.println("검색할 손님의 이름을 입력하세요:");
        String name=sc.next();
        boolean isSearch = false;
        for (String key:cafeHashMap.keySet()){
            if (cafeHashMap.get(key).getName().equals(name)){
                isSearch = true;
                System.out.println("이름: "+cafeHashMap.get(key).getName());
                System.out.println("제조일: "+cafeHashMap.get(key).getCreated());
                System.out.println("주문: "+cafeHashMap.get(key).getOrder());
                System.out.println("가격: "+cafeHashMap.get(key).getPrice());
                System.out.println("매출 여부: "+cafeHashMap.get(key).getExport());
                System.out.println("***************************************");
                System.out.println();
            }
        }
        if (!isSearch){
            System.out.println("방문정보가 없습니다.");
        }
    }
}
