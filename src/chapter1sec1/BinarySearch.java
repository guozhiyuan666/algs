package chapter1sec1;

import edu.princeton.cs.algs4.*;

import java.util.Arrays;
public class BinarySearch
{//二分查找
    public static int rank(int key, int[] a)
    { // 数组必须是有序的
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        { // 被查找的键要么不存在，要么必然存在于 a[lo..hi] 之中
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
    public static int rank2(int key, int[] a)
    {
        int c = 0;
        for(int i = 0; i < a.length; i++)
        {
            if(a[i] < key) c++;
            else if(a[i] >= key) break;
        }
        return c;
    }
    public static int count(int key, int[] a)
    {
        int c = 0;
        for(int i = 0; i < a.length; i++)
        {
            if(a[i] == key) c++;
        }
        return c;
    }
//
//    public static int[] removeduplicated(int[] a)
//    {
//        int[] b = new int[a.length];
//        int count = 0;
//        b[0] = a[0];
//        for(int i = 1;i < a.length; i++)
//        {
//            if(a[i] != b[count])
//            {
//                count++;
//                b[count] = a[i];
//            }
//        }
//        count++;
//        int[] c = new int[count];
//        for (int j = 0; j < c.length; j++)
//        {
//            c[j] = b[j];
//        }
//        return c;

    //删除重复元素的另一个方法：双指针
    public static int[] removeduplicated(int[] a) {
        int p = 0;
        int q = 1;
        while (q < a.length) {
            if (a[p] != a[q]) {
                a[p + 1] = a[q];
                p++;
            }
            q++;
        }
        int[] b = new int[p+1];
        for(int i = 0; i < p+1; i++)
        {
            b[i] = a[i];
        }
        return b;
  }
}