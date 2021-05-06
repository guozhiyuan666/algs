package chapter2sec1;

public class Insertion {
    private static boolean less(Comparable v, Comparable w){//v比w小，则为true；
        return v.compareTo(w) < 0;
    }
    private static void exch(Comparable[] a, int i, int j){//交换元素
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private static void show(Comparable[] a){//打印数组
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static boolean isSorted(Comparable[] a){//检查数组是否有序
        for(int i = 1; i < a.length; i++){
            if(less(a[i], a[i-1])) return false;
        }
        return true;
    }
    //插入排序，对接近有序的数组效率最高
    public static void sort(Comparable[] a){
        for(int i = 1; i < a.length; i++){
            for(int j = i; j > 0 && less(a[j],a[j - 1]); j--){
                exch(a,j,j - 1);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {6,5,9,8,7,-10,6,9};
        show(a);
        Selection.sort(a);
        show(a);
    }
}
