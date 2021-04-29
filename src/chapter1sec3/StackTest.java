package chapter1sec3;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> as1 = new Stack<>();
        as1.push("aa");
        as1.push("bb");
//        System.out.println(as.peek());
//        System.out.println(as.pop());
//        System.out.println(as.peek());
        Stack<String> as2 = new Stack<>();
        as2.push("cc");
        as2.push("dd");

        as1.catenation(as2);
        for(String i : as1){

            System.out.println(i);

        }
    }
}
