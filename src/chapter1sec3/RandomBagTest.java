package chapter1sec3;

public class RandomBagTest {
    public static void main(String[] args) {
        RandomBag<Integer> a = new RandomBag<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        for(int i : a)
            System.out.println(i);
    }
}
