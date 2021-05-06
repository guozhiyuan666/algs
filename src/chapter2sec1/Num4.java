package chapter2sec1;

public class Num4 {
    private static boolean less(Comparable v, Comparable w) {//v比w小，则为true；
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {//交换元素
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void show(Comparable[] a) {//打印数组
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {//检查数组是否有序
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    //插入排序，对接近有序的数组效率最高
    public static void sort(Comparable[] a) {

        for (int i = 1; i < a.length; i++) {
            int t = i;
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {//a[j - 1]比a[j]大的时候直接结束循环，并不会进入循环体，所以元素相同时是复杂度是N-1
                t = j - 1;
                exch(a, j, j - 1);
            }
            System.out.print(" " + i  + " " + t + "     ");
            show(a);
        }
    }
    public static void main(String[] args) {
        //Character[] a = {'E','A','S','Y','Q','U','E','S','T','I','O','N'};
        Integer[] a = { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        Num4.sort(a);
    }
}
