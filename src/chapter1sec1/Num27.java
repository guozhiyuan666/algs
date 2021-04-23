package chapter1sec1;

public class Num27 {
    public static double binomial(int N, int K, double p, double[][] a)
    {
        if(N == 0 && K == 0) return 1.0;
        if(N < 0 || K < 0) return 0.0;
        if(a[N][K] != -1) return a[N][K];

        a[N][K] = (1.0 - p) * binomial(N-1, K, p, a) + p*binomial(N-1, K-1, p, a);
        return a[N][K];

    }
}
