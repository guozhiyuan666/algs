package chapter2sec1;

public class Selection {

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
    /**
    public static void sort(Comparable[] a){//选择排序，遍历数组最小的与前面的交换，每比较一次就交换，
        for(int i = 0; i < a.length; i++){
            for(int j = i + 1; j < a.length; j++){
                if(!less(a[i],a[j])){
                    exch(a,i, j);
                }
            }
        }
    }
     */
    public static void sort(Comparable[] a){//选择排序，遍历数组最小的与前面的交换，将最小值的所以记录下来，最后交换
        for(int i = 0; i < a.length; i++){
            for(int j = i + 1; j < a.length; j++){
                int min = i;
                if(!less(a[i],a[j])){
                    min = j;
                }
                exch(a,i, min);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {5,5,9,8,7,-10,6,9};
        show(a);
        Selection.sort(a);
        show(a);
    }

}
