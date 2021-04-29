package chapter1sec3;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue1 = new Queue<>();
        queue1.enqueue(1);
        queue1.enqueue(2);
        Queue<Integer> queue2 = new Queue<>();
        queue2.enqueue(3);
        queue2.enqueue(4);
        queue1.catenation(queue2);

        System.out.println(queue1.dequeue());
        System.out.println(queue1.dequeue());
        System.out.println(queue1.dequeue());
        System.out.println(queue1.dequeue());

    }

}
