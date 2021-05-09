package chapter2sec2;

import chapter1sec2.Transaction;

public class MergeBU {
    private static Comparable[] aux;

    public static void merge(Comparable[] a, int lo, int mid, int hi){
        for(int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }
        int i = lo;
        int j = mid + 1;
        for(int k = lo; k <= hi; k++){
            if      (i > mid)               a[k] = aux[j++];
            else if (j > hi)                a[k] = aux[i++];
            else if (less(aux[i],aux[j]))   a[k] = aux[i++];
            else                            a[k] = aux[j++];
        }
    }
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void sort(Comparable[] a){
        int N = a.length;
        aux = new Comparable[N];
        for(int sz = 1; sz < N; sz = sz+sz){
            for(int lo = 0; lo < N-sz; lo += sz+sz ){
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }
    }

    /*测试主函数*/
    public static void main(String[] args) {
        Integer[] a = {9,8,7,52,1,6,9,8,6,2,9,5,6,969,5,6,6,8,6};
        PrintArray<Integer> show = new PrintArray<>();
        show.print(a);
        MergeBU.sort(a);
        show.print(a);

        Transaction a1 = new Transaction("a1 2021/02/01 900.0");
        Transaction a2 = new Transaction("a2 2021/02/01 100.0");
        Transaction a3 = new Transaction("a3 2021/02/01 106.0");
        Transaction a4 = new Transaction("a4 2021/02/01 600.0");
        Transaction a5 = new Transaction("a5 2021/02/01 100.0");
        Transaction a6 = new Transaction("a6 2021/02/01 800.0");
        PrintArray<Transaction> showT = new PrintArray<>();
        Transaction [] b = {a1,a2,a3,a4,a5,a6};
        showT.print(b);
        MergeBU.sort(b);
        showT.print(b);

        }

}

