package chapter1sec3;

public class BagTest {
    public static void main(String[] args) {
        Bag<Integer> bag = new Bag<>();
        bag.add(1);
        bag.add(2);
        bag.add(3);
        for(Integer i : bag) System.out.println(i);
        System.out.println(bag.size());
    }
}
