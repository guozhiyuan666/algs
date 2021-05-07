package chapter2sec1;

import edu.princeton.cs.algs4.StdDraw;

public class Num17 {
    private static boolean less(Comparable v, Comparable w){//v比w小，则为true；
        return v.compareTo(w) < 0;
    }
    private static void exch(Comparable[] a, int i, int j){//交换元素
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private static void show(Comparable[] a){//打印数组
        int N = a.length;
        for(int i = 0; i < N; i++){
            System.out.print(" " + a[i] + "  ");
            double x = 1.0 * i / N;
            double y = (double)a[i] / 2.0;
            double rw = 0.5 / N;
            double rh = (double)a[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StdDraw.clear();
    }
    public static boolean isSorted(Comparable[] a){//检查数组是否有序
        for(int i = 1; i < a.length; i++){
            if(less(a[i], a[i-1])) return false;
        }
        return true;
    }

    public static void sort(Comparable[] a){//选择排序，遍历数组最小的与前面的交换，将最小值的所以记录下来，最后交换
        for(int i = 0; i < a.length; i++){
            int min = i;
            for(int j = i + 1; j < a.length; j++){
                if(less(a[j],a[min])){
                    min = j;
                }
            }
            //System.out.print(" " + i  + " " + min + "     ");
            show(a);
            exch(a,i, min);
        }
    }

    public static void main(String[] args) {
        Double[] a = {6.0,5.0,9.0,8.0,1.0,20.0,16.0,19.0};
        Num17.sort(a);

    }

}