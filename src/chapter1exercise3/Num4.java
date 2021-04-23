package chapter1exercise3;

import stackexercise.LinkedStack;
import java.util.Scanner;
public class Num4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedStack<String> aStack = new LinkedStack<String>();
        while (scanner.hasNext()) {
            String item = scanner.next();
            if (aStack.size() >= 1) {
                String p = aStack.pop();
                if (!(item.equals(p))) {
                    aStack.push(p);
                }
            } else {
                aStack.push(item);
            }
        }

        if (aStack.isEmpty()) {
            System.out.println("ture");
        } else {
            System.out.println("false");
        }
    }
}