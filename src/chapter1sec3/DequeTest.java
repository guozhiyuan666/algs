package chapter1sec3;

/**
 * 练习1.3.33 测试用例
 */
public class DequeTest {
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.pushRight(1);
        deque.pushLeft(2);
        deque.pushRight(3);
        deque.pushRight(4);
        System.out.println(deque.popLeft());
        System.out.println(deque.popRight());
        System.out.println(deque.popRight());
        System.out.println(deque.popLeft());
        for(Integer i : deque){
            System.out.println(i);
        }
    }
}
