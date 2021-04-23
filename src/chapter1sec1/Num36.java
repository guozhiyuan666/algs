package chapter1sec1;

import edu.princeton.cs.algs4.StdRandom;

public class Num36 {
    public static void shuffleTest(int M, int N){
        int[][] record = new int[M][M];
        int[] a = new int[M];
        for(int i = 0; i < N; i++){
            reset(a);
            StdRandom.shuffle(a);
            for(int m = 0; m < M; m++){
                for(int n = 0; n < M; n++){
                    if(m == a[n])
                    {
                        record[m][n]++;
                    }
                }
            }
        }
        for(int m = 0; m < M; m++){
            for(int n = 0; n < M; n++){
                System.out.print(record[m][n] + " ");
            }
            System.out.println("\n");
        }
    }
    private static void reset(int[] a){
        for(int j = 0; j < a.length; j++){
            a[j] = j;
        }
    }

}
