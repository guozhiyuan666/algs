package chapter1sec1;

import jdk.swing.interop.SwingInterOpUtils;

public class HistogramTest
{
    public static void main(String[] args)
    {
        int[] a = {0,1,1,2,2,3,4};
        int M = 7;
        int[] result = Histogram.histogram(a,M);
        for(int i = 0; i < result.length; i++) System.out.println(result[i]);

    }
}
