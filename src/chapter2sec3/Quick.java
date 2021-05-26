package chapter2sec3;

import chapter2sec2.Merge;
import chapter2sec2.PrintArray;

public class Quick {
    public static void sort(Comparable[] a){

        sort(a, 0, a.length -1);
    }
    public static void sort(Comparable[] a, int lo, int hi){
        if(lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }
    public static int partition(Comparable[] a, int lo, int hi){
        int i = lo, j = hi + 1;
        Comparable key = a[lo];
        while(true){
            while(key.compareTo(a[++i]) > 0){//从左向右扫描，只要比key小就一直扫描下去。直到遇到比key大的才停止
                if(i == hi) break;
            }
            while(key.compareTo(a[--j]) < 0){//从右向左扫描，只要比key大就一直扫描下去。
                if(j == lo) break;
            }
            if(i >= j) break;
            exch(a, i, j);
        }
         exch(a, lo, j);
        return j;
    }
    public static void exch(Comparable[] a, int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /*测试主函数*/
    public static void main(String[] args) {
        Character[] a = {'T','A','A','T','E','E','E','P','T','I','M','T','T','X','O','A'};
            Quick3way.sort(a);
        PrintArray<Character> show = new PrintArray<>();
        show.print(a);
    }

}
