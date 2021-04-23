package chapter1sec1;

public class Num22 {
    public static int rank(int key,  int[] a, int lo, int hi, int record )
    {
        int mid = lo + (hi - lo) / 2;
        record++;
        if (lo > hi)
        {
            System.out.println("没有该值 " + key);
            return -1;
        }
        if(a[mid] < key)
        {
            for(int i = 0; i < record; i++) System.out.print(" ");
            System.out.println(lo + " " + hi);
            return rank(key, a, mid + 1, hi,record );
        }
        else if(a[mid] > key)
        {
            for(int i = 0; i < record; i++) System.out.print(" ");
            System.out.println(lo + " " + hi);
            return rank(key, a, lo, mid - 1,record );
        }
        else
        {
            System.out.println(key + " 索引为" + mid );
            return mid;
        }
    }
}
