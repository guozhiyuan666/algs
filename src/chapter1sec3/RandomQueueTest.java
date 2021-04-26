package chapter1sec3;

public class RandomQueueTest {
    public static void main(String[] args) {
        RandomQueue<Integer> a = new RandomQueue<>();
        a.enqueue(1);
        a.enqueue(2);
        a.enqueue(3);
        a.enqueue(4);
        for (int i : a) {
            System.out.println(i);
        }

    }
}
