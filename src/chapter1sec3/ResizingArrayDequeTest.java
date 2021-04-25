package chapter1sec3;

public class ResizingArrayDequeTest {
    public static void main(String[] args) {
        ResizingArrayDeque<Integer> rad = new ResizingArrayDeque<>();
        rad.pushLeft(1);
        rad.pushRight(3);
        rad.pushLeft(2);
        rad.pushRight(4);

        for(Integer i : rad){
            System.out.println(i);
        }

//        System.out.println(rad.popLeft());
//        System.out.println(rad.popRight());
//        System.out.println(rad.popLeft());
//        System.out.println(rad.popLeft());
    }
}
