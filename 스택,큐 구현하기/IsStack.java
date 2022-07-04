//made by 진민

package Game10_210601;

public class IsStack {
    static Object[] arSt = new Object[5];
    private Object temp;

    void push(Object obj){  //요소를 저장
        for (int i = 0; i < arSt.length; i++){
            if (arSt[i] == null){
                arSt[i] = obj;
                break;
            }
        }
    }
    Object peek(){  //마지막 데이터를 반환
        temp = "";
        for (int i = 0; i< arSt.length; i++){
            if (arSt[i] != null) temp = arSt[i];
        }
        return temp;
    }
    Object pop(){   //마지막 데이터를 반환하고 삭제
        if (arSt[0] == null) return "";
        else {
            temp = arSt[arSt.length - 1];
            for (int i = 0; i < arSt.length; i++) {
                if (arSt[i] == null) {
                    temp = arSt[i - 1];
                    arSt[i - 1] = null;
                    break;
                }
            }
            return temp;
        }
    }
    Object search(Object obj){  //데이터의 순서 반환
        for (int i = 0; i < arSt.length; i++) {
            if (arSt[i] == obj) {
                return temp = i;
            }
        }
        return -1;
    }
}
