package chapter1sec3;

import java.util.concurrent.Callable;

public class Num29Test {
    //29题环形链表测试用例，只实现了简单的入栈出栈，没有实现迭代
    public static void main(String[] args) {
        Num29<Integer> circleQueue = new Num29<>();
        circleQueue.enqueue(1);
        circleQueue.enqueue(2);
        circleQueue.enqueue(3);
        circleQueue.enqueue(4);
        System.out.println(circleQueue.dequeue());
        System.out.println(circleQueue.dequeue());
        System.out.println(circleQueue.dequeue());
        System.out.println(circleQueue.dequeue());
        System.out.println(circleQueue.dequeue());//这一步抛异常
        }
}

