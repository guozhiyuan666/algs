package chapter1exercise3;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Rene Argento
 */
public class Exercise4 {

    public static void main(String[] args) {
        System.out.println(isBalanced("{(]}"));
    }

    public static boolean isBalanced(String input) {

        char[] parentheses = input.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char parenthesis : parentheses) {
            if (parenthesis == '('
                    || parenthesis == '['
                    || parenthesis == '{') {
                stack.push(parenthesis);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char firstItem = stack.pop();

                if (parenthesis == ')' && firstItem != '('
                        || parenthesis == ']' && firstItem != '['
                        || parenthesis == '}' && firstItem != '{') {
                    return false;
                }
            }
        }
        return true;
    }

}
