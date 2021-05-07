package chapter2sec1;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {
    public static double time(String alg, Comparable[] a){
        Stopwatch timer = new Stopwatch();
        if(alg.equals("Selection")) Selection.sort(a);
        if(alg.equals("Insertion")) Insertion.sort(a);
        if(alg.equals("Shell")) Insertion.sort(a);
        if(alg.equals("Num24")) Num24.sort(a);
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
        String alg3 = args[2];
        String alg4 = args[3];
        int N = Integer.parseInt(args[4]);
        int M = Integer.parseInt(args[5]);
        double time1 = timeRandomInput(alg1, N, M);
        double time2 = timeRandomInput(alg2, N, M);
        double time3 = timeRandomInput(alg3, N, M);
        double time4 = timeRandomInput(alg4, N, M);
        System.out.printf("选择：%f, 插入:%f, 希尔：%f, 插入哨兵:%f", time1, time2,time3,time4);

    }
}
