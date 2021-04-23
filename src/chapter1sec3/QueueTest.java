package chapter1sec3;

import java.util.Scanner;

public class QueueTest
{
    public static void main(String[] args)
    {
        LinkedQueue<String> s = new LinkedQueue<>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            String st = sc.next();
            if(!(st.equals("-")))
            {
                s.enqueue(st);
            }
            else if(!s.isEmpty()) {
                System.out.println(s.dequeue());
            }
        }
        System.out.println("还剩" + s.size());
        System.out.println(s.dequeue());
        System.out.println(s.dequeue());
        System.out.println(s.dequeue());
        System.out.println(s.dequeue());
        s.enqueue("st");
        System.out.println(s.dequeue());

    }

}