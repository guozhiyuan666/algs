package chapter1exercise3;
//测试用例
public class ResizingArrayQueueOfStringTest {
    public static void main(String[] args) {
        ResizingArrayQueueOfStrings raqos = new ResizingArrayQueueOfStrings();
        raqos.enqueue("1");
        raqos.enqueue("2");
        raqos.enqueue("3");

        System.out.println(raqos.dequeue());
        raqos.enqueue("4");
        raqos.enqueue("5");

        System.out.println(raqos.dequeue());
        System.out.println(raqos.dequeue());
        System.out.println(raqos.dequeue());
        System.out.println(raqos.dequeue());


    }
}
