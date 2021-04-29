package chapter1sec3;

/**
 * 练习1.3.32
 */
public class StequeTest {
    public static void main(String[] args) {
        Steque<Integer> steque1 = new Steque<>();
        steque1.push(1);
        steque1.push(2);
        Steque<Integer> steque2 = new Steque<>();

        steque1.catenation(steque2);
        System.out.println(steque1.pop());
        System.out.println(steque1.pop());

    }
}
