package chapter1sec3;

/**
 * 练习1.3.32
 */
public class StequeTest {
    public static void main(String[] args) {
        Steque<Integer> steque = new Steque<>();
        steque.push(1);
        steque.push(2);
        steque.enqueue(3);
        System.out.println(steque.pop());
        System.out.println(steque.pop());
        System.out.println(steque.pop());
    }
}
