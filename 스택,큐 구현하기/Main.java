//made by 진민

package Game10_210601;

public class Main {
    public static void main(String[] args) {

        System.out.println("==========Stack==========");
        IsStack st = new IsStack();

        System.out.println("1. 배열의 상태");
        printStack();
        System.out.println();

        System.out.println("2. push(요소추가)");
        st.push("ㄱ");
        st.push("ㄴ");
        st.push("ㄷ");
        printStack();
        System.out.println();

        System.out.println("3. peek(마지막 데이터 반환)");
        System.out.println("반환 값: " + st.peek());
        printStack();
        System.out.println();

        System.out.println("4. pop(마지막 데이터를 반환하고 삭제)");
        System.out.println("반환 값: " + st.pop());
        printStack();
        System.out.println();

        System.out.println("4. search(데이터 순서 반환)");
        System.out.println("결과 값: " + st.search("ㄴ"));
        printStack();
        System.out.println("\n");

        System.out.println("==========Queue==========");
        IsQueue qe = new IsQueue();

        System.out.println("1. 배열의 상태");
        printQueue();
        System.out.println();

        System.out.println("2. offer(요소를 추가)");
        qe.offer("a");
        qe.offer("b");
        qe.offer("c");
        qe.offer("d");
        qe.offer("e");
        printQueue();
        System.out.println();

        System.out.println("3. peek(첫 번째 데이터를 반환)");
        System.out.println(qe.peek());
        printQueue();
        System.out.println();

        System.out.println("4. poll(첫 번째 데이터를 반환하고 제거)");
        System.out.println(qe.poll());
        printQueue();
        System.out.println();

        System.out.println("5. remove(값 제거)");
        qe.remove();
        printQueue();
        System.out.println();

        System.out.println("6. clear(queue를 초기화)");
        qe.clear();
        printQueue();
        System.out.println();
    }
    static void printStack(){
        IsStack st = new IsStack();
        System.out.print("[");
        if (st.arSt[0] != null)  System.out.print(st.arSt[0]);
        for (int i = 0; i < st.arSt.length - 1; i++){
            if (st.arSt[i + 1] == null) break;
            else System.out.print(", " + st.arSt[i + 1]);
        }
        System.out.println("]");
    }
    static void printQueue(){
        IsQueue qe = new IsQueue();
        System.out.print("[");
        if (qe.arQe[0] != null)  System.out.print(qe.arQe[0]);
        for (int i = 0; i < qe.arQe.length - 1; i++) {
            if (qe.arQe[i + 1] == null) break;
            else System.out.print(", " + qe.arQe[i + 1]);
        }
        System.out.println("]");
    }
}
