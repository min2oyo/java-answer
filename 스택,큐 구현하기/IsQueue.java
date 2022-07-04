//made by 진민

package Game10_210601;

public class IsQueue {
    static Object[] arQe = new Object[5];
    private Object temp;

    void offer(Object obj){ //요소를 추가
        for (int i = 0; i < arQe.length; i++){
            if (arQe[i] == null){
                arQe[i] = obj;
                break;
            }
        }
    }
    Object peek(){  //첫 번째 데이터를 반환
        return arQe[0];
    }
    Object poll(){  //첫 번째 데이터를 반환하고 제거
        if (arQe[0] == null) return "";
        temp = arQe[0];
        for (int i = 0; i < arQe.length; i++){
            if (i + 1 == arQe.length) break;
            else arQe[i] = arQe[i + 1];
        }
        arQe[arQe.length - 1] = null;
        return temp;
    }
    void remove(){  //값 제거
        for (int i = 0; i < arQe.length; i++){
            if (i + 1 == arQe.length) break;
            else arQe[i] = arQe[i + 1];
        }
    }
    void clear(){   //queue를 초기화
        for (int i = 0; i < arQe.length; i++){
            arQe[i] = null;
        }
    }
}
