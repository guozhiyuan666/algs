package chapter1sec3;

import java.util.Scanner;

public class QueueTest
{
    public static void main(String[] args)
    {
        Queue<Integer> que = new Queue<>();
        que.enqueue(2);
        que.enqueue(3);
        System.out.println(que.dequeue());
        System.out.println(que.dequeue());
        que.dequeue();//抛出异常
    }

}