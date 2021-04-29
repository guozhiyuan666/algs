package chapter1sec4;

import chapter1sec1.BinarySearch;

import java.util.Arrays;

public class ThreeSumFast {

    public static int count(int[] a){
        int N = a.length;
        int counter = 0;
        Arrays.sort(a);
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                if(BinarySearch.rank(- a[i] - a[j], a) > j){
                    counter++;
                }
            }
        }
        return counter;
    }

}
