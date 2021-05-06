package chapter1sec4;

import chapter1sec1.BinarySearch;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class TwoSum {

    public static int twoSumFast(int[] a){
        Arrays.sort(a);
        int counter = 0;
        for(int i = 0; i < a.length; i++){
            if(BinarySearch.rank(-a[i], a) > i){
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] a = In.readInts("1Mints.txt");
        System.out.println(twoSumFast(a));
    }

}
