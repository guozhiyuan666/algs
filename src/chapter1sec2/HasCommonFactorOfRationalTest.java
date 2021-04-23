package chapter1sec2;

public class HasCommonFactorOfRationalTest {
    public static void main(String[] args) {
        long a = 200;
        long b = 100;
        long[] re = new long[2];
        //re = Rational.reductionOfFraction(a,b); // 改为静态方法测试一下，测试完注释掉这一句不然报错
        for (int i = 0; i < re.length; i++)
        {
            System.out.println(re[i]);
        }
    }
}
