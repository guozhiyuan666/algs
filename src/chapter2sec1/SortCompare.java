package chapter2sec1;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {
    public static double time(String alg, Comparable[] a){
        Stopwatch timer = new Stopwatch();
        if(alg.equals("Selection")) Selection.sort(a);
        if(alg.equals("Insertion")) Insertion.sort(a);
        return timer.elapsedTime();
    }
    public static double timeRandomInput(String alg, int N, int M){//M个随机的大小为N的数组，排序M次
        Double[] a = new Double[N];
        double sum = 0.0;
        for(int j = 0; j < M; j++){
            for(int i = 0; i < N; i++){
                a[i] = StdRandom.uniform();
            }
            sum += time(alg,a);
        }
        return sum;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int M = Integer.parseInt(args[3]);
        double time1 = timeRandomInput(alg1, N, M);
        double time2 = timeRandomInput(alg2, N, M);
        System.out.printf("t2比t1快，%.2f", time1 / time2);

    }
}
