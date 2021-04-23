package chapter1sec2;

public class Rational {
    private long numerator;
    private long denominator;
    Rational(long numerator, long denominator){
        long[] result = new long[2];
        result = reductionOfFraction(numerator, denominator);
        this.numerator = result[0];
        this.denominator = result[1];
    }
    private long[] reductionOfFraction(long numerator, long denominator){
        long commonFactor = GCD.gcd(numerator, denominator);
        long[] result = new long[2];
        result[0] = numerator / commonFactor;
        result[1] = denominator / commonFactor;
        return  result;
    }
    //和
    public Rational plus(Rational b){
        long denominator_ab = this.denominator * b.denominator;
        long numerator_ab = this.numerator * b.denominator + b.numerator * this.denominator;
        Rational result = new Rational(numerator_ab,denominator_ab);
        return result;
    }
    //差
    public Rational minus(Rational b){
        long denominator_ab = this.denominator * b.denominator;
        long numerator_ab = this.numerator * b.denominator - b.numerator * this.denominator;
        Rational result = new Rational(numerator_ab,denominator_ab);
        return result;
    }
    //积
    public Rational times(Rational b){
        long denominator_ab = this.denominator * b.denominator;
        long numerator_ab = this.numerator * b.numerator;
        Rational result = new Rational(numerator_ab,denominator_ab);
        return result;
    }
    //商
    public Rational divides(Rational b){
        long denominator_ab = this.denominator * b.numerator;
        long numerator_ab = this.numerator * b.denominator;
        Rational result = new Rational(numerator_ab,denominator_ab);
        return result;
    }
    public boolean equals(Object b){
        if(this == b) return true;
        if(b == null) return false;
        if(this.getClass() != b.getClass()) return false;
        Rational that = (Rational) b;
        if(this.numerator != that.numerator) return false;
        if(this.denominator != that.denominator) return false;
        return true;
    }


    public String toString(){
        return "" + this.numerator + " / " + this.denominator;
    }
}
