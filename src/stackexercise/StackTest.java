package stackexercise;

import java.util.Scanner;

public class StackTest
{
    public static void main(String[] args)
    {
        LinkedStack<String> s = new LinkedStack<>();
        //ResizingArrayStack<String> s = new ResizingArrayStack<>();
        // FixedCapacityStack<String> s = new FixedCapacityStack<>(100);
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            String st = sc.next();
            if(!(st.equals("-")))
            {
                s.push(st);
            }
            else if(!s.isEmpty()) {
                System.out.println(s.pop());
            }
        }
        System.out.println("还剩" + s.size());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        s.push("st");
        System.out.println(s.pop());

    }

}
