package chapter1sec1;
import edu.princeton.cs.algs4.StdRandom;

public class Num35 {

    public static void randomDots(int N){
        StdRandom.setSeed(3566684);
        int[] count = new int[13];
        int a = 0;
        int b = 0;
        int sum = 0;
        for(int i = 0; i < N; i++){
            a = StdRandom.uniform(1,7);
            b = StdRandom.uniform(1,7);
            sum = a + b;
            count[sum]++;
        }
        for(int j = 0; j < 13; j++){
            System.out.println(count[j] / (double)N);
        }

    }

}
