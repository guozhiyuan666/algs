package chapter2sec1;
/*
练习2.1.24 插入排序的哨兵，一种规避边界测试的方法，能够省略判断条件的元素通常叫做哨兵
 */
public class Num24 {
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
        findminmal(a);        //将最小元素放在数组开头，可以省略j<0这个判断条件
        for(int i = 1; i < a.length; i++){
            for(int j = i; less(a[j],a[j - 1]); j--){
                exch(a,j,j - 1);
            }
        }
    }
    public static void findminmal(Comparable[] a){
        int min = 0;
        for(int i = 1;i < a.length; i++){
            if(a[i].compareTo(a[min]) < 0){ min = i;}
        }
        exch(a,0,min);
    }

    public static void main(String[] args) {
        Integer[] a = {6,5,9,8,7,-10,6,9,-20};
        show(a);
        Num24.sort(a);
        show(a);
    }
}
