package chapter1sec1;

public class Num27Test {
    public static void main(String[] args) {
        int N = 50;
        int K = 25;
        double p = 0.2;
        double[][] a = new double[N+1][K+1];
        for(int i = 0; i < N+1 ; i++)
            for(int j = 0; j < K+1 ; j++)
                a[i][j] = -1;
        double b = Num27InBook.binomial(N, K, p);
        //double b = Num27.binomial(N, K, p,a);
        System.out.println(b);

    }
}
