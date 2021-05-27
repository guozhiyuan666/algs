package chapter2sec3;

import chapter2sec2.PrintArray;

public class Num1 {
    public static void show(Comparable[] a){
        PrintArray<Comparable> show = new PrintArray<>();
        show.print(a);
    }
    public static void sort(Comparable[] a){
        sort(a, 0, a.length - 1);
    }
    public static void sort(Comparable[] a, int lo, int hi){
        if( lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }
    private static int  partition(Comparable[] a, int lo, int hi){
        Comparable v = a[lo];
        int i = lo , j = hi + 1;
        while(true){
            while(a[++i].compareTo(v) < 0) if(i == hi) break;
            while(a[--j].compareTo(v) > 0) if(j == lo) break;
            if(j <= i) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
    public static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /*测试主函数*/
    public static void main(String[] args) {
        Character[] a = { 'I','T','S','A','V','E','R','W','E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S','T','I', 'O', 'N'};
        Num1.sort(a);
        show(a);
    }

}
