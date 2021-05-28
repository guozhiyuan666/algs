package chapter2sec3;

import chapter2sec2.PrintArray;
//练习2.3.22 快速三向切分
public class Fast3WayPartitioning {
    public static void sort(Comparable[] a){
        quickSort(a, 0, a.length - 1);
    }
    /*自己写的sort方法，不对。。
    public static void sort(Comparable[] a, int lo, int hi){
        if(lo >= hi) return;
        int p, q, i, j;
        p = i = lo + 1;
        q = j = hi;
        Comparable v = a[lo];
        while(i < j){
            if(a[i].compareTo(v) == 0)              {exch(a, i, p++);}
            if(a[j].compareTo(v) == 0)              {exch(a, j, q--);}
            while(a[++i].compareTo(v) < 0)          {if(i == j) break;}
            while(i < j && a[--j].compareTo(v) > 0) {if(j == i) break;}
            //System.out.println(i +" " + j + " " + p +" " + q);
            exch(a, i, j);
        }
        for(int k = lo; k < p; k++){
            exch(a, k, --j);
        }
        for(int k = hi; k > q; k--){
            exch(a, k, i++);
        }
        sort(a, lo, j-1);
        sort(a, i, hi);
    }
     */
    private static void quickSort(Comparable[] array, int low, int high) {

        if (low >= high) {
            return;
        }

        int i = low;
        int j = high + 1;

        int p = low;
        int q = high + 1;

        Comparable pivot = array[low];

        while (true) {

            if (i > low && array[i].compareTo(pivot) == 0) {
                exch(array, ++p, i);
            }
            if (j <= high && array[j].compareTo(pivot) == 0) {
                exch(array, --q, j);
            }

            while (array[++i].compareTo(pivot) < 0) {
                if (i == high) {
                    break;
                }
            }

            while (pivot.compareTo(array[--j]) < 0) {
                if (j == low) {
                    break;
                }
            }

            //pointers cross
            if (i == j && array[i].compareTo(pivot) == 0) {
                exch(array, ++p, i);
            }
            if (i >= j) {
                break;
            }

            exch(array, i, j);
        }

        //Currently:
        // array[low..p] == pivot
        // array[p..i] < pivot
        // array[j..q] > pivot
        // array[q..high] == pivot

        i = j + 1;

        for(int k = low; k <= p; k++) {
            exch(array, k, j--);
        }
        for(int k = high; k >= q; k--) {
            exch(array, k, i++);
        }

        //Now:
        // array[low..j] < pivot
        // array[j..i] == pivot
        // array[i..high] > pivot

        quickSort(array, low, j);
        quickSort(array, i, high);
    }
    public static void exch(Comparable[] a, int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void show(Comparable[] a){
        PrintArray<Comparable> show = new PrintArray<>();
        show.print(a);
    }
    /*测试主函数*/
    public static void main(String[] args) {
        Character[] a = {'T','A','A','T','E','X','B','W','B','Y','T','T','B','Z','A','S'};
        Fast3WayPartitioning.sort(a);
        show(a);
    }
}
