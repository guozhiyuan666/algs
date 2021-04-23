package chapter1sec3;

import stackexercise.LinkedStack;

import java.util.Scanner;

public class LinkedBagTest
{
    public static void main(String[] args)
    {
        LinkedBag<String> s = new LinkedBag<>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            String st = sc.next();
            if(!(st.equals("-")))
            {
                s.add(st);
            }
        }
        for(String i : s)
        {
            System.out.println(i);
        }
    }

}
