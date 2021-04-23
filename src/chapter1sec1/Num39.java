package chapter1sec1;

import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

public class Num39 {
    public static void main(String[] args) {
        int T = 50;
        int N = 10000;
        int sum = 0;
        for(int i = 0; i < T; i++){
            sum = sum + duplicated(N);
        }
        System.out.println(sum / (double)T);
    }
    public static int duplicated(int N){
        int[] a = new int[N];
        int[] b = new int[N];
        for(int i = 0; i <  N; i++){
            a[i] = StdRandom.uniform(100000,1000000);
            b[i] = StdRandom.uniform(100000,1000000);
        }
        int c = 0;
        for(int j = 0; j < a.length; j++){
            Arrays.sort(b);
            int index = BinarySearch.rank(a[j], b);
            if(index != -1) c++;
        }
        return c;
    }

}
