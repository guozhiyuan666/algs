package chapter1sec3;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> as = new Stack<>();
        as.push("1");
        as.push("2");
        as.push("3");
        as.push("4");
        Stack<String> as2 = new Stack<>(as);

        as2.pop();

        for(String i : as){
            System.out.println(i);//
        }

        for(String i : as2){
            System.out.println(i);//
        }



    }
}
