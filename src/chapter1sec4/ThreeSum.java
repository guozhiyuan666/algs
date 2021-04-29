package chapter1sec4;

import edu.princeton.cs.algs4.In;

public class ThreeSum {
    public static int count(int[] a)
    {
        int counter = 0;
        int N = a.length;
        for(int i = 0; i < N ; i++){
            for(int j = i + 1; j < N; j++){
                for(int k = j + 1; k < N; k++){
                    if((a[i] + a[j] + a[k]) == 0){
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] all = In.readInts("8Kints.txt");
        System.out.println(ThreeSumFast.count(all));
        System.out.println(count(all));
    }

}
