package chapter1sec4;

import edu.princeton.cs.algs4.StdOut;

/**
 * 数组的局部最小元素
 */
public class Num18 {
    public static int loaclMinElement(int[] a)
    {
        int lo=1;  //首位预留一个，防止超出索引
        int hi=a.length-2;
        int mid;
        int localMinIndex=-1;
        //find in rang smaller
        while(lo<=hi && localMinIndex==-1)
        {
            mid=(lo+hi)/2;
            if(a[mid]<a[mid-1] && a[mid]<a[mid+1])
                localMinIndex=mid;
            else if(a[mid-1]<a[mid+1])
                hi=mid-1;
            else if(a[mid-1]>a[mid+1])
                lo=mid+1;
        }
        //
        lo=1;
        hi=a.length-2;
        while(lo<=hi && localMinIndex==-1)
        {
            mid=(lo+hi)/2;
            if(a[mid]<a[mid-1] && a[mid]<a[mid+1])
                localMinIndex=mid;
            else if(a[mid-1]<a[mid+1])
                lo=mid+1;
            else if(a[mid-1]>a[mid+1])
                hi=mid-1;
        }
        return localMinIndex;
    }//end min
    public static void main(String[] args)
    {
        int[] a={7,6,9,5,4,3,2,1};
        StdOut.println(loaclMinElement(a));
    }
}

