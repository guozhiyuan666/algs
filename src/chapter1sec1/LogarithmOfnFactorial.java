package chapter1sec1;

public class LogarithmOfnFactorial {
    public static void main(String[] args) {
        int N = 5;
        double result = lonf(N);
        System.out.println(result);
    }

    public static double lonf(int N)
    {
        double sum = Math.log(N);
        if(N == 1) return 0;
        return sum + lonf(N-1);
    }
}
