package chapter1sec1;

public class Histogram
{
    public static int[] histogram(int[] a, int M)
    {
        int[] b = new int[M];
        for(int i = 0; i < a.length; i++) {
            if(a[i] < M)   b[a[i]]++;
        }
        return b;
    }

}
