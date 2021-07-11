package chapter2sec2;
/*
自顶向下的递归归并
 */
public class Merge {

    private static Comparable[] aux;
    public static void merge(Comparable[] a, int lo, int mid, int hi){//原地归并的抽象方法，归并之前两边数组是有序的
        int i = lo, j = mid + 1;//i是左边数组的头，j是右边数组的头

        for(int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }
        for(int k = lo; k <= hi; k++){
            if      (i > mid)                   a[k] = aux[j++];  //左边数组*********************
            else if (j > hi)                    a[k] = aux[i++];  //右边数组已经排序完成，全部放进了a[]
            else if (less(aux[j], aux[i]))      a[k] = aux[j++];  //aux[j]比aux[i]小，把aux[j]赋值给a[k],然后j++
            else                                a[k] = aux[i++];  //                 把aux[i]赋值给a[k],然后i++
        }
        show(a, lo, mid, hi);
    }
    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    /*自顶向下的递归归并*/
    public static void sort(Comparable[] a){
        int N = a.length;
        aux = new Comparable[N];
        sort(a , 0, N - 1);
    }
    private static void sort(Comparable[] a, int lo, int hi){
        if(lo >= hi) return;
        int mid = (lo + hi) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void show(Comparable[] a, int lo, int mid, int hi){
        System.out.print(lo + " " + mid + " " + hi + " ");
        for(int i = 0; i < a.length; i++){
            System.out.print( a[i] + " ");
        }
        System.out.println("\n");
    }

    /*测试主函数*/
    public static void main(String[] args) {
        Character[] a = {'E','A','S','Y','Q','U','E','S','T','I','O','N'};
        Merge.sort(a);
        PrintArray<Character> show = new PrintArray<>();
        show.print(a);
    }

}
