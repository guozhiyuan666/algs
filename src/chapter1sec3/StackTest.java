package chapter1sec3;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> as = new Stack<>();
        as.push("dd");
        as.push("gg");
        as.pop();
        System.out.println(as.pop());
    }
}
