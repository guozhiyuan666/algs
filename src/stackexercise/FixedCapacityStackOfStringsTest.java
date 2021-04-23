package stackexercise;

import edu.princeton.cs.algs4.*;

public class FixedCapacityStackOfStringsTest
{

    public static void main(String[] args)
    {
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(100);
        while (!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            if(!item.equals("-"))
            {
                s.push(item);
            }
            else if (!s.isEmpty()) {
                System.out.print(s.pop() + " ");
            }
        }
        System.out.println("(" + s.size() + "left on stack");
    }

}
