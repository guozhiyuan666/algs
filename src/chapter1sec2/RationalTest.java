package chapter1sec2;

public class RationalTest {
    public static void main(String[] args) {
        Rational a = new Rational(2,3);
        Rational b = new Rational(1,3);
        Rational c = new Rational(4,6);
        System.out.println(a);
        System.out.println(a.plus(b));
        System.out.println(a.minus(b));
        System.out.println(a.times(b));
        System.out.println(a.divides(b));
        if(a.equals(c)) System.out.println("值相等");
    }
}
